# A Plan

This document talks generally about a possible plan for Thesis.

## Examine goals and design

Some goals and design elements demand certain approaches. For example, undo and
multi-user support come to mind. Other elements can be deferred and implemented
as other things fit into place.

## Design a data-driven architecture.

I'd prefer that the entire application state be kept in a minimal number of
Clojure refs; perhaps only one! If the LWJGL classes can be built as a result of
data, so much the better!

## Consider using Functional Reactive Programming

From https://en.wikipedia.org/wiki/Functional_reactive_programming:

> Functional reactive programming (FRP) is a programming paradigm for reactive
> programming (asynchronous dataflow programming) using the building blocks of
> functional programming (e.g. map, reduce, filter). FRP has been used for
> programming graphical user interfaces (GUIs), robotics, and music, aiming to
> simplify these problems by explicitly modeling time."

## Maybe build an event-driven system

If all changes were done via a stream of immutable events, it would be easy to
keep distributed editors in sync. Each would only need to replay the events from
the others.

## Maybe build LWJGL Diffing functionality

This may not make any sense, but I'm going to write it down anyway. If Thesis
could "diff" LWJGL in the same way that React.js diffs HTML, then "re-rendering"
a change would be cheap. It would mean that most of the editor could simply work
with data.

## Build a basic custom editor control for text editing

Text editing is just one part of Thesis!

## Build first iteration of communication protocol

If I'm already using a data-driven approach, this may go more smoothly.

## Think through implications of multi-user support

TODO

## Improve the custom editor control

TODO
