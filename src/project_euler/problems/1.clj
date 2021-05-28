(ns project-euler.problems.1
  (:require [project-euler.utils :as utils]))

;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
;; The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn- sum-of-non-multiples [n m1 m2]
  (-> n
      utils/sum-to-n
      (+ (utils/sum-to-n n (* m1 m2)))
      (- (utils/sum-to-n n m1) (utils/sum-to-n n m2))))

(def solution (time (sum-of-non-multiples 1000 3 5)))
