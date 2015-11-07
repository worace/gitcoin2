(ns git-coin.db
  (:require [yesql.core :as sql]
            [environ.core :refer [env]]))

(def config (env :database-url))

(sql/defqueries "db/queries/examples.sql")

(defn create-example!
  [name admin pass]
  (create-example<!
   config
   name admin nil pass))
