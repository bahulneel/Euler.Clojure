(use 'clojure.math.numeric-tower)

(defn is-prime? [number]
  (let [square-root (sqrt number)]
    (loop [factor 3]
      (if (> factor square-root)
        true
        (if (= (rem number factor) 0)
          false
          (recur (+ factor 1)))))))

(defn get-nth-prime [position]
  (if (= position 1)
    2
    (loop [candidate 3 next-position 2]
      (if (is-prime? candidate)
        (if (= next-position position)
          candidate
          (recur (+ candidate 2) (+ next-position 1)))
        (recur (+ candidate 2) next-position)))))

(println (get-nth-prime 10001))

