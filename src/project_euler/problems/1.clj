(ns project-euler.problems.1)

;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
;; The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn- is-not-a-multiple-of-n? [n x] (not (= 0 (mod x n))))

(defn- sum-of-non-multiples [n & multiples]
  (transduce (filter (apply every-pred (map #(partial is-not-a-multiple-of-n? %) multiples))) + (range n)))

(def solution (time (sum-of-non-multiples 1000 3 5)))
