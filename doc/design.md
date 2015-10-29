# Design

This design document lays out some of the design decisions and architecture of
Thesis. It flows from the goals of the project.

## Dependencies

### Built with Clojure 1.7

I personally find Clojure to be productive, clear, and a joy to use. Clojure 1.7
was released around June 30, 2015.

> We are pleased to announce the release of Clojure 1.7. The two headline
> features for 1.7 are transducers and reader conditionals. Also see the
> complete list of all changes since Clojure 1.6 for more details.
> - http://blog.cognitect.com/blog/2015/6/30/clojure-17

has not yet been released; it is in alpha. According to the Clojure
mailing list, 1.7 final may be ready in 2015 Q1.

### Requires Java 8

Java steadily evolves, so I'd prefer to target a recent but not bleeding-edge
version of it. For now, Java 8 seems reasonable. As of December 2014, Java 8 is
well-adopted, according to the [Typesafe survey: Java 8 Adoption Strong][TSJA].

[TSJA]: http://www.infoq.com/news/2014/12/Typesafe-surveys-Java-Adoption

> Typesafe recently released a report based on their survey findings of over
> 3000 Java developers, focusing on the adoption of Java 8 as well as upcoming
> developer technology trends. From the survey results, the Java 8 adoption rate
> overall looks strong, particularly since version 8 had been available for only
> six months when the survey was taken back in September 2014. This is
> significant as Oracle’s Java 7 support will potentially end as early as
> April 2015.

> The report shows that 27% of those who filled out the survey have already
> upgraded to Java 8, with a further 36% planning to upgrade within the next 12
> months (from the time of taking the survey). Only 23% of respondents were yet
> to evaluate Java 8.

> 21% of those who already upgraded to the latest Java version are using it in
> production, with a further 36% in staging or planning to upgrade their
> production environment shortly and 40% running pilots or testing with Java 8.

### Built with LWJGL

I chose LWJGL because it claims to simplify Java interaction with OpenGL
functionality.

> LWJGL is a Java library that enables cross-platform access to popular native
> APIs useful in the development of graphics (OpenGL), audio (OpenAL) and
> parallel computing (OpenCL) applications. This access is direct and
> high-performance, yet also wrapped in a type-safe and user-friendly layer,
> appropriate for the Java ecosystem.

> LWJGL is an enabling technology and provides low-level access. It is not a
> framework and does not provide higher-level utilities than what the native
> libraries expose. As such, novice programmers are encouraged to try one of the
> frameworks or game engines that make use of LWJGL, before working directly
> with the library.

> LWJGL is open source software and freely available at no charge.

## Software Development Principles

This is only a starting list; it is not complete.

### Avoid dynamically-scoped singleton resources

Dynamic global vars tend to lock an application into behaving like a singleton
and require extra care when using threads. I could anticipate that almost any
abstraction in Thesis may need to have multiple copies.

Stuart Sierra explains this clearly and with detail in
[On the Perils of Dynamic Scope][OPDS].

[OPDS]: http://stuartsierra.com/2013/03/29/perils-of-dynamic-scope

> This brings me to one of my top anti-patterns in Clojure: the
> Dynamically-Scoped Singleton Resource (DSSR).

> The DSSR is popular in libraries that depend on some external resource such as
> a socket, file, or database connection. It typically looks like this:

```clj
(ns com.example.library)

(def ^:dynamic *resource*)

(defn- internal-procedure []
  ;; ... uses *resource* ...
  )

(defn public-api-function [arg]
  ;; ... calls internal-procedure ...
  )
```

> That is, there is a single dynamic Var holding the “resource” on which the
> rest of the API operates. The DSSR is often accompanied by a with-* macro:

```clj
(defmacro with-resource [src & body]
  `(binding [*resource* (acquire src)]
     (try ~@body
       (finally
       (dispose *resource*)))))
```

> This looks harmless enough. It’s practically a carbon copy of Clojure’s
> with-open macro, and it ensures that the resource will get cleaned up even if
> body throws an exception.

> The problem with this pattern, especially in libraries, is the constraints it
> imposes on any code that wants to use the library. The with-resource macro
> severely constrains what you can do in the body:

> You can’t dispatch to another thread. Say goodbye to Agents, Futures, thread
> pools, non-blocking I/O, or any other kind of asynchrony. The resource is only
> valid on the current thread.

> You can’t return a lazy sequence backed by the resource because the resource
> will be destroyed as soon as body returns.

> You can’t have more than one resource at a time. Hence the “singleton” in the
> name of this pattern. Using a thread-bound Var throughout the API means that
> you can never operate on more than one instance of the resource in a single
> thread. Lots of apps need to work with multiple databases, which really sucks
> using this kind of library.

> The last problem with this pattern is a more subtle one: hidden
> dependencies. The public API functions, which have global scope, depend on the
> state (thread-local binding) of another Var with global scope. This dependency
> isn’t explicitly stated anywhere in the definition of those functions. That
> might not seem like such a big deal in small examples, and it isn’t. But as
> programs (and development teams) grow larger, it’s one additional piece of
> implicit knowledge that you have to keep in your head. If there are seventeen
> layers of function calls between the resource binding and its usage, how
> certain are you going to be that the resource has the right extent?
