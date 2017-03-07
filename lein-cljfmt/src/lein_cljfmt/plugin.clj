(ns lein-cljfmt.plugin
  (:require [cljfmt.core :as cljfmt]
            [cljfmt.config :refer [default-config config]]
            [leiningen.core.eval :refer [eval-in-project]]
            [leiningen.core.project :as p]
            [meta-merge.core :refer [meta-merge]]))

(defn middleware
  [project]
  (let [opts (meta-merge default-config (:cljfmt project {}))]
    (update-in project [:injections] concat
               `[(require 'cljfmt.config)
                 (reset! 'cljftm.config/config ~opts)])))
