(use 'clojure.math.numeric-tower)

(defn is-prime? [number]
  (let [square-root (sqrt number)]
    (loop [factor 3]
      (if (> factor square-root)
        true
        (if (= (rem number factor) 0)
          false
          (recur (+ factor 1)))))))

(defn sum-primes [until]
  (loop [candidate 3 sum 2]
    (if (>= candidate until)
      sum
      (if (is-prime? candidate)
        (recur (+ candidate 2) (+ sum candidate))
        (recur (+ candidate 2) sum)))))

(println (sum-primes 2000000))

