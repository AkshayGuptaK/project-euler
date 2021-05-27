(ns project-euler.problems.2)

(defn- fib-up-to-n [n]
  (loop [a 1
         b 2
         acc [a b]]
    (let [c (+ a b)]
      (if (< n c)
        acc
        (recur b c (conj acc c))))))  

(defn- sum-even-fib-to-n [n]
  (transduce (filter even?) + (fib-up-to-n n)))

(def solution (time (sum-even-fib-to-n (* 4 1000 1000))))
