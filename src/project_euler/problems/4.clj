(ns project-euler.problems.4
  (:require [project-euler.utils.utils :as utils]))

;; A palindromic number reads the same both ways.
;; The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
;; Find the largest palindrome made from the product of two 3-digit numbers.

;; assuming there is a six digit solution it must fulfill:
;; 100000 a + 10000 b + 1000 c + 100 c + 10 b + a
;; = 100001 a + 10010 b + 1100 c
;; = 11(9091a + 910b + 100c)
;; where a, b, c are the first three digits

(defn- is-palindrome?
  "Returns whether the given six digit number is a palindrome.
   We check if the first three digits fulfill the above equation to determine this."
  [num]
  {:pre [(and (> num 99999) (< num 1000000))]}
  (let [digits (utils/to-digits num)
        first-digit (first digits)
        second-digit (second digits)
        third-digit (nth digits 3)]
    (= num (+ (* 100001 first-digit) (* 10010 second-digit) (* 1100 third-digit)))))

(defn- find-largest-palindrome-product
  "Find the largest palindrome that is a product of two 3 digit numbers.
   We exploit the fact that one of the numbers must be a product of 11 to achieve a 10x speedup."
  []
  (->> (for [x (range 100 1000) y (range 10 (quot 1000 11))] (* 11 x y))
       (filter (every-pred #(> % 99999) is-palindrome?))
       (apply max)))

(def solution (time (find-largest-palindrome-product)))
