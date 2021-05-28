(ns project-euler.problems.7
  (:require [project-euler.utils :as utils]))

(defn- nth-prime
  "Returns the nth prime number"
  [n]
  (loop [i 2
         primes []]
    (if (= n (count primes))
      (dec i)
      (recur (inc i) (cond-> primes
                       (utils/is-prime? i primes) (conj i))))))

(def solution (time (nth-prime 10001)))

