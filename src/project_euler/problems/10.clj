(ns project-euler.problems.10
  (:require [project-euler.utils.prime :as prime]))

;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;; Find the sum of all the primes below two million.

(defn- sum-of-primes
  "Returns the sum of all prime numbers up to `n`"
  [n]
  (apply +' (prime/primes-up-to n)))

(def solution (time (sum-of-primes 2000000)))

