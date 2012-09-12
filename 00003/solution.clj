(defn update-prime-candidates [current step candidates]
  (if (candidates current)
    (recur (+ current step) step candidates)
    (assoc candidates current step)))

(defn get-next-prime [current candidates]
  (let [step (candidates current)]
    (let [next (+ current 2)]
      (if (candidates current)
        (recur next 
          (update-prime-candidates (+ current step) step (dissoc candidates current)))
        (cons next
          (lazy-seq
            (get-next-prime next
              (assoc candidates (* current current) (* current 2)))))))))

(defn get-primes []
  (cons 2
    (lazy-seq
      (get-next-prime 3 {}))))

(defn get-prime-factors [product]
  (for [prime (get-primes)]
    (when (= (rem product prime) 0)
      prime)))

(println (apply max (filter (comp not nil?) (get-prime-factors 600851475143))))

