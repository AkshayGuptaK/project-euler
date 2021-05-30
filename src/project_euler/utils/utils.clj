(ns project-euler.utils.utils
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

(defn ceil-of-sqrt
  "Returns the smallest number whose square is greater than or equal to `n`"
  [n]
  (let [[quotient remainder] (numeric/exact-integer-sqrt n)]
    (cond-> quotient
      (> remainder 0) inc)))

(defn first-multiple-greater-than
  "Returns the first multiple of `n` greater than or equal to the `minimum`"
  [n minimum]
  (* n (numeric/ceil (/ minimum n))))

