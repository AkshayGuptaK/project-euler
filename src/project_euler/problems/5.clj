(ns project-euler.problems.5
  (:require [clojure.math.numeric-tower :as numeric]
            [project-euler.utils :as utils]))

;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

(defn- primes-up-to
  "Returns all the primes up to and including `limit`"
  [limit]
  (loop [n 2
         primes []]
    (if (> n limit)
      primes
      (recur (inc n) (cond-> primes
                       (utils/is-prime? n primes) (conj n))))))

(defn- highest-power-up-to
  "Returns the highest power of `num` whose value is less than or equal to `limit`"
  [limit num]
  (loop [n num
         exp 1]
    (if (> (numeric/expt n exp) limit)
      (numeric/expt n (dec exp))
      (recur n (inc exp)))))

(defn- smallest-evenly-divisible-by-all-up-to
  "Returns the smallest positive number that is evenly divisible by all numbers up to and including `limit`"
  [limit]
  (transduce (map (partial highest-power-up-to limit)) * (primes-up-to limit)))

(def solution (time (smallest-evenly-divisible-by-all-up-to 20)))
