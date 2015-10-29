# Abstractions

What abstractions does Thesis need?

I will walk through some key abstractions here.

## User / Identity

Thesis needs a represent users and/or identity in order to handle multi-user
concurrent editing.

I expect that most 'traditional' editors (such as Emacs) assume that the current
operating system user is also the primary editor of the documents. There are
editors that build in notions of multi-user colloboration. Thesis should borrow
ideas from them.

## File

Since Thesis needs to interact with operating system files, it will need to have
a file abstraction.

## Buffer

Thesis needs a 'broader' abstraction than files. This could support functionality
such as:

* Editing text not yet saved to disk
* Providing various interaction patterns not strictly tied to a file; e.g. the
  same file could be presented and edited in different ways

Emacs has a buffer abstraction:

> Aside from its textual contents, each buffer records several pieces of
> information, such as what file it is visiting (if any), whether it is
> modified, and what major mode and minor modes are in effect (see Modes). These
> are stored in buffer-local variables—variables that can have a different value
> in each buffer.

## Application

This may be obvious, but Thesis should have an abstraction to keep
application-level data. Such data contrasts with user-specific data.
