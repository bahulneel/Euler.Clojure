(defn get-factors [number]
  (if (= number 1)
    [1]
    (let [half-number (/ number 2)]
      (loop [factor 2 factors [1]]
        (if (<= factor half-number)
          (let [next-factor (+ factor 1)]
            (if (= (rem number factor) 0)
              (recur next-factor (conj factors factor))
              (recur next-factor factors)))
          (conj factors number))))))

(defn get-first-triangle-number-with-n-divisors [n]
  (loop [triangle 1 naturals (drop 2 (range))]
    (if (>= (count (get-factors triangle)) n)
      triangle
      (recur (+ triangle (first naturals)) (drop 1 naturals)))))

(println (get-first-triangle-number-with-n-divisors 501))

