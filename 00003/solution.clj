(defn eliminate-multiples [factor product limit candidates]
  (if (<= product limit)
    (let [remaining-candidates (if (contains? candidates product) (disj candidates product) candidates)]
      (recur factor (+ product factor) limit remaining-candidates))
    candidates))

(defn get-primes [start end primes]
  (if (<= start end)
    (recur (+ start 1) end (eliminate-multiples start (* start 2) end primes))
    primes))

(defn get-prime-factors [product]
  (let [primes (get-primes 2 product (apply hash-set (range 1 product)))]
    (for [prime primes]
      (when (= (rem product prime) 0)
        prime))))

(println (apply max (filter (comp not nil?) (get-prime-factors 600851475143))))

