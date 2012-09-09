(defn get-integers [start end integers]
  (if (<= start end)
    (get-integers (+ start 1) end (conj integers start))
    integers))

(defn eliminate-multiples [factor product limit candidates]
  (if (<= product limit)
    (let [remaining-candidates (if (contains? candidates product) (disj candidates product) candidates)]
      (eliminate-multiples factor (+ product factor) limit remaining-candidates))
    candidates))

(defn get-primes [start end primes]
  (if (<= start end)
    (get-primes (+ start 1) end (eliminate-multiples start (* start 2) end primes))
    primes))

(defn get-prime-factors [product]
  (let [primes (get-primes 2 product (get-integers 1 product (sorted-set))) prime-factors (set)]
    (for [prime primes]
      (if (= (rem product prime) 0)
        (conj prime-factors prime)
        prime-factors))))

(println (max (get-prime-factors 600851475143)))

