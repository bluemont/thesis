# Goals

This is (at least) my third revision of my brainstorming process for an
editor. What are my goals for this project?

## Current Goals

### Customizable

I want Thesis to be as customizable as Emacs.

### Emacs, Improved

I want to borrow the best parts of Emacs and improve upon them.

### Desktop-Based

From what I can tell, the desktop-based apps still hold the lead for complex,
developer-oriented applications. They excel at interacting with files, source
control. They offer more access to the underlying computer power.

Also, there is no reason why a desktop app can't leverage distributed computing
technology.

I realize that web technologies are evolving rapidly and the gap is
closing. Maybe I'm wrong here.

### Clojure-First

Clojure is an amazing language with a fantastic standard library and smooth
interoperation with many Java libraries. It blows the doors off Emacs Lisp.

### Keyboard-First

Editing files is much faster if you can work primarily from the keyboard.

### Primarily Graphical

Yes, editing files is primarily a textual activity, but limiting an editor to a
terminal is rather constraining.

Yes, there are times when you want to edit files on a remote filesystem. To
handle this use-case, I want Thesis to offer a daemon that you can run on the
remote system. Then your local device (a computer or mobile device) connects to
that remote system.

Setting the expectation that an 'editing' application should be graphical
changes the focus. I want Thesis to cause people to pause and think 'what is the
best user experience to accomplish my goal' without assuming a-priori that a
traditional, text-centric paradigm is the best.

All of this said, writing customizable, configurable, extensible user interfaces
is not as 'easy' as relying on the more basic abstractions you see in other
editors such as Emacs: buffers, files, status lines, and so on. It will require
some thinking, planning, and experimentation.

### Distributed Collaboration

Multiple users should be able to connect to each other for collaboration. There
is no requirement for a central server.

### Cross-Platform

LWJGL (Java + OpenGL) should simplify cross-platform behavior.

## Discarded Goals

### Client/Server Architecture

I am not comfortable with a client/server architecture for these reasons:

* Latency: I want the application to respond quickly to user input.
* Complexity: A client/server architecture adds significant complexity.
* Development Speed: A client/server split would likely delay the project
  development considerably.

That said, there are advantages of a Client/Server architecture:

* The server would act as the "foundation" for code that is more general than
  client code. This might drive a better design. This would be a potential
  advantage. Still, this can be achieved without a client/server separation; it
  can be achieved with namespace separation.

All in all, I plan to avoid a client/server architecture.

### Browser-Based

I am not enthralled by a browser-based editor. It feels too limiting. I'd rather
have Clojure available with multiple cores. A browser-based editor could use
JavaScript, sure. There are plenty of other editors innovating in the browser
space.
