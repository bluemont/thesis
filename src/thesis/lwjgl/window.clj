(ns thesis.lwjgl.window
  "Window functions."
  (:import
   [org.lwjgl BufferUtils]
   [org.lwjgl.glfw GLFW]
   [org.lwjgl.opengl GL11])
  (:require
   [thesis.lwjgl.opengl :as opengl]
   [thesis.util :refer [safe-get]]))

(def kw->c
  {:visible GLFW/GLFW_VISIBLE
   :resizable GLFW/GLFW_RESIZABLE})

(defn set-default-hints
  []
  (GLFW/glfwDefaultWindowHints))

(defn set-hints
  [props]
  (doseq [[k v] props]
    (GLFW/glfwWindowHint (safe-get kw->c k) (safe-get opengl/kw->c v))))

(defn show
  [win]
  (GLFW/glfwShowWindow win))

(defn create
  "Creates a window and its associated OpenGL or OpenGL ES context. Most
  of the options controlling how the window and its context should be
  created are specified with window hints. Returns the handle of the
  created window, or nil if an error occurred."
  [width height title monitor share]
  (GLFW/glfwCreateWindow
   ^int width ^int height (str title) ^long monitor ^long share))

(defn destroy
  [window]
  (GLFW/glfwDestroyWindow window))

(defn size
  "Retrieves the size, in screen coordinates, of the client area of the
  specified window. If you wish to retrieve the size of the framebuffer
  of the window in pixels, see GetFramebufferSize."
  [^long window]
  (let [width (BufferUtils/createIntBuffer 1)
        height (BufferUtils/createIntBuffer 1)]
    (GLFW/glfwGetWindowSize window width height)
    [(.get width 0) (.get height)]))

(defn center
  "Centers the window on the specified monitor."
  [window monitor]
  (let [m (GLFW/glfwGetVideoMode monitor)
        mw (.getWidth m)
        mh (.getHeight m)
        [ww wh] (size window)]
    (GLFW/glfwSetWindowPos window (/ (- mw ww) 2) (/ (- mh wh) 2))))
