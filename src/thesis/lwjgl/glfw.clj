(ns thesis.lwjgl.glfw
  "GLFW is an Open Source, multi-platform library for creating windows
  with OpenGL contexts and receiving input and events. It is easy to
  integrate into existing applications and does not lay claim to the
  main loop. (from http://www.glfw.org/)"
  (:import
   [org.lwjgl.glfw GLFW GLFWErrorCallback GLFWKeyCallback]
   [org.lwjgl.opengl GL11])
  (:require
   [thesis.lwjgl :as lwjgl]))

(defn init
  "Initializes the GLFW library and returns true if successful. Throws
  an exception on failure."
  []
  (if (= (GLFW/glfwInit) GL11/GL_TRUE)
    true
    (throw (ex-info "Failed to initialize GLFW" {}))))

(defn terminate
  ""
  []
  (GLFW/glfwTerminate))

(defn with-init
  [f]
  (init)
  (f)
  (terminate))

(defn set-error-callback
  "Sets the error callback, which is called with an error code and a
  human-readable description each time a GLFW error occurs."
  [callback]
  (GLFW/glfwSetErrorCallback callback))

(defn set-key-callback
  "Sets the error callback, which is called with an error code and a
  human-readable description each time a GLFW error occurs."
  [window callback]
  (GLFW/glfwSetKeyCallback window callback))

(defn build-error-callback
  "Builds and returns an error callback."
  []
  (GLFWErrorCallback/createPrint System/err))

(defn build-key-callback
  "Builds and returns a key callback"
  []
  (proxy [GLFWKeyCallback] []
    (invoke [window key scan-code action mods]
      (if (and (= key GLFW/GLFW_KEY_ESCAPE)
               (= action GLFW/GLFW_RELEASE))
        (GLFW/glfwSetWindowShouldClose window GL11/GL_TRUE)))))

(defn with-error-callback
  [f]
  (let [callback (build-error-callback)]
    (set-error-callback callback)
    (f)
    (lwjgl/release callback)))

(defn with-key-callback
  [window f]
  (let [callback (build-key-callback)]
    (set-key-callback window callback)
    (f)
    (lwjgl/release callback)))

(defn make-context-current
  [window]
  (GLFW/glfwMakeContextCurrent window))

(defn enable-vsync
  []
  (GLFW/glfwSwapInterval 1))
