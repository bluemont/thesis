(defproject thesis "0.1.0-SNAPSHOT"
  :description "Thesis: A customizable text editor."
  :url "https://github.com/bluemont/thesis"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies
  [[medley "0.7.0"]
   [org.clojure/clojure "1.7.0"]
   [org.lwjgl/lwjgl "3.0.0b-SNAPSHOT"]
   [org.lwjgl/lwjgl-platform "3.0.0b-SNAPSHOT"
    :classifier "natives-osx"
    :native-prefix ""]]
  :repositories
  [["sonatype snapshots"
    {:url "https://oss.sonatype.org/content/repositories/snapshots"}]]
  :main thesis.app
  :jvm-opts ["-XstartOnFirstThread"])
