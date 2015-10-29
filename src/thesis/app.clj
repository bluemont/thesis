(ns thesis.app
  (:require
   [thesis.lwjgl :as lwjgl]
   [thesis.lwjgl.glfw :as glfw]
   [thesis.lwjgl.window :as window])
  (:import
   [org.lwjgl.glfw GLFW]
   [org.lwjgl.opengl GL GL11 GL20]))

(defn create-window
  [{:keys [width height title monitor share]}]
  (window/set-default-hints)
  (window/set-hints {:visible false
                     :resizable true})
  (if-let [w (window/create width height title monitor share)]
    w
    (throw (ex-info "Failed to create a window" {}))))

(defn with-window
  [{:keys [width height title monitor share] :as params} f]
  (let [window (create-window params)]
    (f window)
    (window/destroy window)))

(defn versions
  "Returns a map of version information."
  []
  {:thesis "0.0.0"
   :os-name (System/getProperty "os.name")
   :os (System/getProperty "os.version")
   :lwjgl (lwjgl/version)})

(defn opengl-versions
  "Returns a map of version information."
  []
  {:opengl (GL11/glGetString GL11/GL_VERSION)
   :opengl-shading-language
   (GL11/glGetString GL20/GL_SHADING_LANGUAGE_VERSION)})

(defn with-init
  [f]
  (let [v (versions)]
    (println "Thesis Version:" (:thesis v))
    (println "OS:" (:os-name v) (:os v))
    (println "LWJGL Version:" (:lwjgl v)))
  (glfw/with-error-callback
    (fn []
      (glfw/with-init
        (fn []
          (with-window
            {:width 400 :height 300 :title "Thesis" :monitor 0 :share 0}
            (fn [window]
              (glfw/with-key-callback window
                (fn []
                  (glfw/make-context-current window)
                  (glfw/enable-vsync)
                  (window/show window)
                  (GL/createCapabilities)
                  (let [v (opengl-versions)]
                    (println "OpenGL Version:" (:opengl v))
                    (println "OpenGL Shading Language Version:"
                             (:opengl-shading-language v)))
                  (f window))))))))))

(defn run
  []
  (with-init
    (fn [window]
      (GL11/glClearColor 0.4 0.6 0.4 0.75)
      (while (= (GLFW/glfwWindowShouldClose window) GL11/GL_FALSE)
        (GL11/glClear (bit-or GL11/GL_COLOR_BUFFER_BIT
                              GL11/GL_DEPTH_BUFFER_BIT))
        (GLFW/glfwSwapBuffers window)
        (GLFW/glfwPollEvents)))))

(defn -main
  []
  (run))
