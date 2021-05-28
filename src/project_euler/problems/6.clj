(ns project-euler.problems.6
  (:require [clojure.math.numeric-tower :as numeric]
            [project-euler.utils :as utils]))

(defn- difference-of-squares
  "Returns the difference between the square of the sum to `n` and the sum of the first `n` squares."
  [n]
  (- (numeric/expt (utils/sum-to-n n) 2) (utils/sum-of-squares n)))

(def solution (time (difference-of-squares 100)))

