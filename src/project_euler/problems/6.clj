(ns project-euler.problems.6
  (:require [clojure.math.numeric-tower :as numeric]
            [project-euler.utils :as utils]))

;; The sum of the squares of the first ten natural numbers is 385.
;; The square of the sum of the first ten natural numbers is 3025.
;; Hence the difference between the sum of the squares of the
;; first ten natural numbers and the square of the sum is 2640.
;; Find the difference between the sum of the squares of the
;; first one hundred natural numbers and the square of the sum.

(defn- difference-of-squares
  "Returns the difference between the square of the sum to `n` and the sum of the first `n` squares."
  [n]
  (- (numeric/expt (utils/sum-to-n n) 2) (utils/sum-of-squares n)))

(def solution (time (difference-of-squares 100)))

