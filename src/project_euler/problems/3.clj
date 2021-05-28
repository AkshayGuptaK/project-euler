(ns project-euler.problems.3
  (:require [clojure.math.numeric-tower :as numeric]))

(defn- smallest-factor [n]
  (->> n
       numeric/exact-integer-sqrt
       first
       (range 2)
       (filter #(= 0 (mod n %)))
       first))

(defn- prime-factorization [num]
  (loop [n num
         factors []]
    (if-let [factor (smallest-factor n) ]
      (recur (/ n factor) (conj factors factor))
      (conj factors n))))

(def solution (time (apply max (prime-factorization 600851475143))))
