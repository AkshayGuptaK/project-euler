(ns project-euler.problems.1)

(defn- is-not-a-multiple-of-n? [n x] (not (= 0 (mod x n))))

(defn- sum-of-non-multiples [n & multiples]
  (transduce (filter (apply every-pred (map #(partial is-not-a-multiple-of-n? %) multiples))) + (range n)))

(def solution (time (sum-of-non-multiples 1000 3 5)))
