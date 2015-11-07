(defproject git-coin "0.1.0-SNAPSHOT"
  :description "GitCoin: Simplistic cryptocurrency simulator."
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :main git-coin.core
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [http-kit "2.1.18"]
                 [environ "1.0.1"]
                 [com.taoensso/timbre "4.1.1"]
                 [ring-logger-timbre "0.7.0"]
                 [migratus "0.8.4"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [yesql "0.4.2"]
                 [hiccup "1.0.5"]
                 [ring "1.4.0"
                  :exclusions [ring/ring-jetty-adapter
                               ring/ring-servlet]]
                 [ring/ring-defaults "0.1.2"]
                 [clj-time "0.11.0"]
                 ]
  :plugins [[lein-ring "0.8.13"]
            [migratus-lein "0.1.7"]
            [lein-environ "1.0.1"]]
  :ring {:handler git-coin.handler/app}
  :migratus {:store                :database
             :migration-dir        "db/migrations/"
             :migration-table-name "schema_migrations"
             :db (or (System/getenv "DATABASE_URL")
                     "postgres://localhost/git-coin_development")
             }
  :uberjar-name "git-coin.jar"
  :profiles
  {:uberjar {:omit-source true
             :env {:production true}
             :aot :all}
   :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]
         :env {:database-url "postgres://localhost/git-coin_development"}}})
