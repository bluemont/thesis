# Inspirations

## Component Entity System

* See
[Chris Granger's Talk at ClojureScript](https://www.youtube.com/watch?v=V1Eu9vZaDYw).
* See [Gambit by Chris Granger](https://github.com/ibdknox/gambit).
* See [LightTable source code](https://github.com/LightTable/LightTable).

## Emacs

### Emacs Strengths

* I like how Emacs is programmable, customizable, and keyboard-oriented.
* Emacs has a better customization system than any other editor I've seen, since
code is at the core.
* Org Mode is amazing.

### Emacs Weaknesses

* In my experience, Elisp is inferior to Clojure.
* Many of the plugins for Emacs are hard to understand. It seems to me that many
are overly complicated due to design decisions of Emacs.
* Packaging systems in Emacs seems like an afterthought. Pinning versions, for
  example, is difficult.

## Sublime Text

### Sublime Strengths

* Easy to use
* Looks great
* Cross platform

### Sublime Weaknesses

* Not as configurable as Emacs

### Sublime Commentary

Sublime is an modern text-editor, but it does not truly break new ground.

## LightTable

### LightTable Strengths

* "Files are not the best representation of code, just a convenient
serialization." Yes!
* "Editors can be anywhere and show you anything - not just text." Yes!

### LightTable Weaknesses

+ Few, if any, tests, last time I checked.

### LightTable Commentary

* LT broke new ground. This is no small thing.
* How suitable is the Component-Entity System?

## Devcards

* [Devcards source code](https://github.com/bhauman/devcards)
* [Brad Hauman's video introduction at Strange Loop](https://www.youtube.com/watch?v=G7Z_g2fnEDg)

### Devcard Strengths

* Flattens application states (including temporal states, exceptional states,
  and more) into one page
* Quickly prototype interactive elements outside of the application logic and
  flow.

### Devcard Weaknesses

* Devcards is a specific tool with some particular goals; I don't have a good
  sense of 'weaknesses' yet.

### Devcards Commentary

* Devcards is currently implemented in ClojureScript.
* It is built to facilitate interactivity with a web browser; it does not
  require any special interaction with a text editor.
* Could the ideas be part of the fundamental abstractions for a text editor?
