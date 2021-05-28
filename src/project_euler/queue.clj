(ns project-euler.queue)

(def EmptyQueue clojure.lang.PersistentQueue/EMPTY)

(defn make-queue
  "Construct a queue from `coll` or constructs an empty queue if no `coll` supplied"
  ([] (make-queue []))
  ([coll]
   (reduce conj EmptyQueue coll)))

(defn pipe
  "Pipe `k` elements from `source` queue to `destination` queue, or to a new queue if no `destination` supplied"
  ([source k] (pipe source k EmptyQueue))
  ([source k destination]
   (loop [source source
          destination destination
          i k]
     (if (= 0 i)
       [source destination]
       (recur (pop source) (conj destination (peek source)) (dec i))))))
