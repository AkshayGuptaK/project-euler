(ns project-euler.utils
  (:require [clojure.math.numeric-tower :as numeric]))

(defn divides?
  "Returns whether the `divisor` cleanly divides the `dividend`"
  [dividend divisor]
  (= 0 (mod dividend divisor)))

(defn sum-to-n
   "Returns the sum of numbers from 0 to `n` in steps of `step`"
  ([n] (sum-to-n n 1))
  ([n step]
   (-> n
       (quot step)
       (#(* % (inc %)))
       (/ 2)
       (* step))))

(defn sum-of-squares
  "Returns the sum of squares of numbers from 0 to `n`"
  [n]
  (-> n
      (#(* % (inc %)))
      (* (inc (* 2 n)))
      (/ 6)))

(defn to-digits
  "Returns a vector of the digits of `n`"
  [n]
  (->> n
       str
       (map (comp read-string str))))

(defn floor-of-sqrt
  "Returns the greatest number whose square is less than or equal to `n`"
  [n]
  (first (numeric/exact-integer-sqrt n)))

(defn is-prime?
  "Determines if `n` is prime when provided with all primes smaller than `n`"
  [n all-smaller-primes]
  (->> all-smaller-primes
       (take-while #(<= % (floor-of-sqrt n)))
       (not-any? (partial divides? n))))
