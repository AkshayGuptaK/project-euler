(ns project-euler.problems.7
  (:require [project-euler.utils :as utils]))

;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;; What is the 10001st prime number?

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

