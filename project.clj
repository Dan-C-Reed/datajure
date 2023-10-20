(defproject datajure "0.1.0-SNAPSHOT"
  :description "An open-source domain-specific language for data processing."
  :url "https://clojure-finance.github.io/datajure-website/"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [techascent/tech.ml.dataset "7.014"]
                 [scicloj/tablecloth "7.014"]
                 [com.github.clojure-finance/clojask "2.0.2"]
                 [zero.one/geni "0.0.40"]
                 [com.fasterxml.jackson.core/jackson-core "2.15.2"]
                 [metrics-clojure "2.10.0"]
                 [org.apache.poi/poi "5.2.3"]
                 [org.apache.zookeeper/zookeeper "3.7.2" :exclusions [org.slf4j/slf4j-log4j12]]]
  :main ^:skip-aot datajure.dsl
  :target-path "target/%s"
  :jvm-opts ["--add-opens=java.base/java.nio=ALL-UNNAMED",
             "--add-opens=java.base/java.net=ALL-UNNAMED",
             "--add-opens=java.base/java.lang=ALL-UNNAMED",
             "--add-opens=java.base/java.util=ALL-UNNAMED",
             "--add-opens=java.base/java.util.concurrent=ALL-UNNAMED"]
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :provided {:dependencies [[org.apache.spark/spark-core_2.12 "3.1.1" :exclusions [org.slf4j/slf4j-log4j12]]
                                       [org.apache.spark/spark-mllib_2.12 "3.1.1"]
                                       [org.apache.spark/spark-sql_2.12 "3.1.1"]
                                       [org.apache.arrow/arrow-vector "2.0.0"
                                        :exclusions [commons-codec com.fasterxml.jackson.core/jackson-databind]]]}})
