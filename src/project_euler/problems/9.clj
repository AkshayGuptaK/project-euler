(ns project-euler.problems.9
  (:require [clojure.math.numeric-tower :as numeric]
            [project-euler.utils.utils :as utils]))

;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;; a^2 + b^2 = c^2
;; For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.

;; a + b + c = 1000 => c = 1000 - a - b
;; a^2 + b^2 = (1000-a-b)^2
;; (a-1000)(b-1000) = 500000
;; b = 500000/(a-1000) + 1000
;; we can see that a and b are limited to a maximum of 500

(defn- b-from-a
  "Derive b from `a` using the above equation"
  [a]
  (->> (- a 1000)
       (/ 500000)
       (+ 1000)))

(defn- abc
  "Finds integers a and b fulfilling above constraints, then uses them to calculate product of a, b, and c"
  []
  (let [[a b] (transduce (comp (map b-from-a) (filter integer?)) conj [] (range 1 500))
        c (-> (numeric/expt a 2)
              (+ (numeric/expt b 2))
              utils/floor-of-sqrt)]
    (* a b c)))

(def solution (time (abc)))

