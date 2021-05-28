(ns project-euler.utils
  (:require [clojure.math.numeric-tower :as numeric]))

(defn divides?
  "Returns whether the `divisor` cleanly divides the `dividend`"
  [dividend divisor]
  (= 0 (mod dividend divisor)))

(defn sum-to-n
   "Returns the sum of numbers from 0 to `n` in steps of `step`"
  ([n] (sum-to-n n 1))
  ([n step]
   (-> n
       (quot step)
       (#(* % (inc %)))
       (/ 2)
       (* step))))
