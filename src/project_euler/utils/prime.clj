(ns project-euler.utils.prime
  (:require [project-euler.utils.utils :as utils]))

(defn is-prime?
  "Determines if `n` is prime when provided with all primes smaller than `n`"
  [n all-smaller-primes]
  (->> all-smaller-primes
       (take-while #(<= % (utils/floor-of-sqrt n)))
       (not-any? (partial utils/divides? n))))

(defn- primes-by-trial-division
  "Uses repeated division attempts to determine all primes up to `limit`"
  [limit]
  (reduce
   (fn [primes n] (cond-> primes
                       (is-prime? n primes) (conj n)))
   []
   (range 2 limit)))

(defn- exclude-prime-multiples
  "Mark all multiples of prime `p` in the `segment`"
  [start end segment p]
  (if-let [multiple-markers (seq (interleave
                                  (map #(- % start)
                                       (range (max (utils/first-multiple-greater-than p start) (* p p))
                                              end
                                              p))
                                  (repeat false)))]
                                   (apply assoc! segment multiple-markers)
                                   segment))

(defn- primes-in-segment
  "Find all the primes in a transient `segment` where 0th index of segment represents the number `start`."
  [segment start end]
  (:primes (reduce (fn [{:keys [primes segment] :as all} n]
                     (if (nth segment (- n start))
                       {:primes (conj primes n)
                        :segment (exclude-prime-multiples start end segment n)}
                       all))
                   {:primes [] :segment segment}
                   (range start end))))

(defn- create-segment
  "Create a transient vector of `size` with all values as true"
  [size]
  (-> size
      (repeat true)
      vec
      transient))

(defn- sieve-segment
  ""
  [sieve segment-size start end]
  (let [needed-sieve (take-while #(< % (utils/ceil-of-sqrt end)) sieve)
        exclude-multiples (partial exclude-prime-multiples start end)]
    (reduce
     exclude-multiples 
     (create-segment segment-size)
     needed-sieve)))

(defn- segmented-sieve-of-erastothenes
  ""
  [limit]
  (let [segment-size (utils/ceil-of-sqrt limit)
        segment (-> segment-size
                    create-segment
                    (assoc! 0 false 1 false))
        sieve (primes-in-segment segment 0 segment-size)]
    (reduce
     (fn [primes start]
       (let [end (min (+ start segment-size) limit)]
         (concat primes (primes-in-segment
                         (sieve-segment sieve segment-size start end)
                         start
                         end))))
     sieve
     (range segment-size limit segment-size))))

(defn- sieve-of-erastothenes
  ""
  [limit]
  (let [bools (-> limit
                  create-segment
                  (assoc! 0 false 1 false))
        sieve (primes-in-segment bools 0 limit)]
    sieve))

(defn primes-up-to
  "Returns a list of all the primes up to `limit`"
  [limit]
  (if (< limit 3) '() (sieve-of-erastothenes limit)))

