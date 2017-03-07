(ns cljfmt.config
  #?@(:clj
       [(:require
          [clojure.java.io :as io])]
      :cljs
       [(:require-macros [cljfmt.config :refer [read-resource]])]))

#?(:clj (def read-resource* (comp read-string slurp io/resource)))
#?(:clj (defmacro read-resource [path] `'~(read-resource* path)))

(def default-indents
  (merge (read-resource "cljfmt/indents/clojure.clj")
         (read-resource "cljfmt/indents/compojure.clj")
         (read-resource "cljfmt/indents/fuzzy.clj")))

(def default-config
  {:indents default-indents})

(def config (atom nil))
