(defproject project-euler "0.1.0-SNAPSHOT"
  :description "Project Euler: Solutions in Clojure"
  :url "https://github.com/AkshayGuptaK/project-euler"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :main ^:skip-aot project-euler.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
