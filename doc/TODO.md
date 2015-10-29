# Thesis Design TODO

## Inbox

### TODO: How to show (global) but (overriden) minor modes?

Perhaps use a custom menu item control.

### TODO: Question: Do I want global minor modes?

I think so.

### TODO: Question: Do I want buffer-specific minor modes?

I think so.

### TODO: Consider a "self-detecting" repeating feature.

If the editor sees you repeating something, e.g. up then [, over and over. It
should notice, boil it down the essence, display the command, and let you repeat
that command simply.

Note: repeating the same exact key, e.g. "up, up, up" is perhaps useful but not as powerful as I'm imagining.

Now, understanding the semantics of keystrokes is hard. Sometimes when ending
the jagged end of a line, you get lucky with the arrow keys. You don't
absolutely have to use CTRL-E. But a really smart self-detector would realize
you are near the end of the line -- and it would pay attention to where the
cursor ends up. So, to put this another way, the functionality does not only
depend on what you type, but where the cursor goes to.

Yes, you could do this with macros, but why? The editor can tell you.

** Next Actions

** Someday

** Done
