# Features

## Pervasive Undo

Using immutable data without side effects should provide undo/redo functionality
without unnecessary complexity. To properly support undo, the functionality will
need to be built into the editor at its core.

## Pervasive Multi-User Support

Thesis will be designed to support multiple users at all levels.

## Org Mode, Improved

Org Mode is amazing and can be improved. This will take time.

## A Nice Status Bar

The default status line in Emacs is not awesome.

## Clean Hiding

It annoys me that Emacs Org mode does not really hide :PROPERTIES:. I feel like
hiding could be handled as a more general problem. Perhaps hiding is just a
special case of different "views" on a buffer.

## Embedded nREPL

It is relatively easy for Thesis to start an embedded nREPL server so that other
Clojure processes can connect.

## Basic Text Editing

The essentials of editing text should at least as good as Emacs.

## Unicode Support

Thesis should display Unicode characters.

## Syntax Highlighting

Syntax highlighting is important.

## Clojure Syntax Highlighting

Of all syntax highlighting, I care most about Clojure.

## Quick and Responsive

Fast; no lag when editing text.

## Multiple Windows

Like Emacs, Thesis should support multiple windows.

## Designed for pair programming

Multiple Thesis instances can be interconnected with different keybindings and
different views. If I want this, I will need to design for it up front.

## Coexisting keybindings per user

Each user should be able to have his/her own keybindings.

## Multiple cursors in a pane

## Multiple cursors across panes

Why not allow multiple cursors in multiple files at the same time?

## Highlighting

Emacs has [hi-lock mode](http://www.emacswiki.org/emacs/HiLock), which is handy.

## Flexible Key Bindings

I don't want Thesis to force any particular key bindings. All key bindings must
be customizable.

## Rich UI inside buffers

A buffer (if we call it that) should support:

* Text Areas
* Tables
* Trees

All of which should be navigable via the keyboard.

For inspiration, think about Apple's Numbers application. It exists in the
'spreadsheet' category but still allows for multiple input and display types to
exist alongside the tables.

## Multiple Representations

I like the name "Facets". Buffers (if we call them that) should be viewable in
multiple ways:

* Raw Text
* (One or More) Processed Views

Note: A View is "just" a viewer/editor of a Buffer. A Facet is another, separate
idea. A Facet is a representation of a view; it transforms how the viewer
presents the content. It may be textual, graphical, or auditory.

## Graphics Support

* Support bitmaps.
* Support vector graphics.
* Support high-density displays, such as the Apple Retina.

## Audio

Documents can embed audio for playback.

## Folding

Emacs has nice code folding, so should Thesis.

## Autocomplete

## A Package Manager

Compare various package managers and choose the best elements.

## Package Version Number Pinning

## Tabs

In Emacs, I miss tabs from other editors. I find myself digging through Emacs
buffer lists unnecessarily.

## Excellent Find File Functionality

Sublime Text and Textmate have excellent file-finding functionality. Emacs has
it, but it feels clunky to me.

## Excellent Window Creation Control

Emacs puts / "pops up" windows in various places, not all of which are
predictable. I want Thesis to do better.

## Excellent Window Save/Restore

So far, with Emacs, I've found that Workgroups2 is the best window management
tool. Still, I've found that it has many limitations:

* It does not compartmentmentalize buffers across projects.
* It does not have a nice view of the current projects.

## Hyperlinks

Hyperlinks are fairly easy. However, linking to files on the local file system
are problematic. Solve this problem if possible.

## Content-Addressable Links

Hyperlinks are not very suitable for software developers that clone repositories
in different locations. I would like a system where you embed, say, a UUID in a
document comment and use that for addressability.

## Source Control

Git, especially. Emacs has Magit. People like it. Can Thesis do even better? I
hope so.

## Built-In Manual

Like Emacs.

## Context-Aware Help

The editor probably could predict what key bindings you are likely to use based
on where you are.

## Editor Watches You

If Thesis watches what keys and functions you use, it can help you later,
perhaps with learning or quick-reference card creation.

## Keypress For "I Messed Up"

Here is how it works. Press a key indicating you messed up. Thesis will remember it
and stash this information away.

Breaking habits requires that you become aware of mistakes!

I think most people will want this feature once they know it is possible.

## Ergonomic Suggestions

A plugin that reminds you to stretch.

## Sleepiness Detection

People use editors. They sometimes need some help and reminding to say "you are
tired -- take a break."

## Mood Detection

Biometrics might also detect if a user was sleepy, frustrated, and so on. This
could be useful.

## Getting Things Done

I really like Org Mode, but I think it can be improved for GTD. I want to think
like Rich Hickey and decompose the elements of GTD so that we don't have to
force it on anyone.

## Keystroke Dynamics

http://en.wikipedia.org/wiki/Keystroke_dynamics

## User Detection

It would be awesome if your editor knew who was using the editor, based on
biometrics such as typing.

## Typing Tutor similar to GNU Typist

See http://www.gnu.org/software/gtypist/#introduction

## Typing Sound

Some people find a typing sound to be comforting. This would be a fun feature.

##  Sublime-Style Mini-Map

I want Thesis to be able to display a mini-map, even if I don't think that
feature itself is regularly useful. The underlying concept is that the whole
editor is data, so different visualizations of it should be achievable.

## Distraction-Free Writing

How nice!

## Narrowing/Widening

Like Emacs. I'd like this to work well in all (or most) modes.

## Zen Coding

This could be added later.

## Writing Analytics

* See [750words.com’s writing analytics][750].

[750]: http://blog.handcraft.com/2010/05/5-innovations-in-text-editing-and-ides/

## Spaced Repetition to Learn Key Bindings

One of the challenges with Emacs is learning new key bindings. If the editor
itself remembered which ones you used, then it could use spaced-repetition
algorithms to help you remember them.
