(ns project-euler.problems.3
  (:require [clojure.math.numeric-tower :as numeric]
            [project-euler.utils.utils :as utils]))

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn- smallest-factor
  "Returns the smallest non-trivial prime factor of `n` between `smallest` and `largest`.
   If `n` is prime it returns nil."
  [n smallest largest]
  (->> (range smallest largest)
       (filter (partial utils/divides? n))
       first))

(defn- prime-factorization
  "Returns all the non-trivial prime factors of `num`.
   If `num` is prime it returns [`num`]."
  [num]
  (let [largest-factor (/ num 2)]
    (loop [n num
           factor 2
           factors []]
      (if-let [factor (smallest-factor n factor largest-factor)]
        (recur (/ n factor) factor (conj factors factor))
        (conj factors n)))))

(def solution (time (apply max (prime-factorization 600851475143))))
