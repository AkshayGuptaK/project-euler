(ns project-euler.problems.3
  (:require [clojure.math.numeric-tower :as numeric]))

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn- smallest-factor [n]
  "Returns the smallest non-trivial prime factor of `n`.
   If `n` is prime it returns nil."
  (->> n
       numeric/exact-integer-sqrt
       first
       (range 2)
       (filter #(= 0 (mod n %)))
       first))

(defn- prime-factorization [num]
  "Returns all the non-trivial prime factors of `num`.
   If `num` is prime it returns [`num`]."
  (loop [n num
         factors []]
    (if-let [factor (smallest-factor n) ]
      (recur (/ n factor) (conj factors factor))
      (conj factors n))))

(def solution (time (apply max (prime-factorization 600851475143))))
