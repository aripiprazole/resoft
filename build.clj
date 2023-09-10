(ns build
  (:require [clojure.tools.build.api :as b]))

;; SECTION: Settings
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file "target/resoft.jar")

;; Clears build directory.
(defn clean [_]
  (b/delete {:path "target"}))

;; Builds a jar with all dependencies to be possible to
;; build an executable file to resoft's language.
(defn uberjar [_]
  (clean nil)
  (b/copy-dir {:src-dirs ["src"]
               :target-dir class-dir})
  (b/compile-clj {:basis basis
                  :src-dirs ["src"]
                  :class-dir class-dir})
  (b/uber {:class-dir class-dir
           :uber-file jar-file
           :basis basis
           :main 'resoft.main}))