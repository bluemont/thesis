(ns thesis.lwjgl
  "LWJGL is a Java library that enables cross-platform access to popular
  native APIs useful in the development of graphics (OpenGL),
  audio (OpenAL) and parallel computing (OpenCL) applications. This
  access is direct and high-performance, yet also wrapped in a type-safe
  and user-friendly layer, appropriate for the Java ecosystem."
  (:import
   [org.lwjgl Sys]
   [org.lwjgl.system Retainable]))

(defn version
  "Returns the LWJGL version as a string."
  []
  (Sys/getVersion))

(defn release
  "Decrements the reference count. When the reference count reaches
  zero, any resources held by the Retainable object are released. After
  this happens, calling any other method on the object has undefined
  results."
  [^Retainable r]
  (.release r))
