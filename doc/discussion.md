# Discussion

## Questions

### What concepts might help simplify Thesis?

The list of abstractions in 'doc/abstractions.md' is a good start. I can revisit
this question from time to time.

### What are some smart ways to decompose Thesis?

* Design and implement the essential low-level abstractions, such as buffers.
* Layer and compose other abstractions on top of the low-level ones.

### What are some interesting programmatic techniques to use?

* Reactive Programming
* Reactive Functional Programming
* Dataflow Programming
* Component Entity Systems
* Data-Driven Programming

### How might Inversion of Control work?

What if Thesis used inversion of control to make its start-up be completely
controlled by the user? This may be useful or it might not.

Typically, editors start by loading a core set of functionality. Some editors
more favored by programmers start up and then read a configuration
file. However, to my knowledge, the editor is still mostly in control.

What if Thesis did not have one "blessed" entry point? What if Thesis was more
of an "editor API"?

Thesis could ship with an example minimal bootstrapping process. Users could use
it or change it completely.

Note: I don't know how much of the startup process would be done at runtime and how
much would be done as a "build" process. I tend to be inclined to keep as much
behavior at run-time as possible.

### Can we do better than random-access editing?

According to [Wikipedia's article on Emacs][Wikipedia Emacs], the [E editor][E]
improved upon the TECO editor by allowing random-access editing.

[E]: https://en.wikipedia.org/wiki/Emacs#cite_note-9

[Wikipedia Emacs]: https://en.wikipedia.org/wiki/Emacs

> E had another feature that TECO lacked: random-access editing. TECO was a
> page-sequential editor that was designed for editing paper tape on the PDP-1
> and typically allowed editing on only one page at a time, in the order of the
> pages in the file. Instead of adopting E's approach of structuring the file
> for page-random access on disk, Stallman modified TECO to handle large buffers
> more efficiently and changed its file-management method to read, edit, and
> write the entire file as a single buffer. Almost all modern editors use this
> approach.

Here is a head-scratcher that may make no sense: If random-access is better than
sequential-access, what is better than random-access?

### Is there a generalization of multiple cursors?

Multiple cursors are very interesting, but I don't want to stop there if there
is something more general.

I'll start with this question: "why is a cursor useful?":

* To focus an action on one part of the code.
* To show where the focus is.

What is a cursor? Here are multiple perspectives:

* A region with no width.
* A pointer to a particular character.
* A pointer to the space between characters, in some cases.

Why use multiple cursors:

* To allow the same operation to be done at multiple points.
* To show exactly where the operation will be done.

### Think about and perhaps apply my thoughts on annotation

In graduate school, I spent quite a bit of time thinking about annotating
text. I have a book full of notes on it.

### Is there an abstraction for splitting apart buffers?

I think, according to the Emacs manual, that a buffer can be a subset of another
buffer. For Thesis, this could be achieved in several ways I think. One way is
to allow buffers to compose. This may not be very practical. Another way is to
allow addressability; then slicing up buffers becomes easier.

### I like the idea of dynamic narrowing of files.

For example, if I'm editing a view in a Clojure web application, I'd like the
editor to be smart and show me related chunks from other files, as I
type. Finding a way to indicate this clearly in the UI will require some
thinking and experimentation.

### Is it possible to decouple the core editor from the GUI technology?

To some degree, yes.

Now if one's goal were to find a "least common denominator" among GUI toolkits
and support them all, that would result in much pain. It would be a big
challenge, for example, to abstract over LWJGL, Cocoa, Qt, and Tcl/Tk.

### What are the advantages of decoupling the core editor from the GUI?

* Separation of concerns
* Improved testability
* Perhaps a simpler, clearer communication protocol
