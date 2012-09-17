(defn is-evenly-divisible? [number factors]
  (loop [remaining-factors factors]
    (if (= (count remaining-factors) 0)
      true
      (if (= (rem number (first remaining-factors)) 0)
        (recur (drop 1 remaining-factors))
        false))))

(defn get-smallest-evenly-divisible-number [factors largest-factor]
  (loop [candidate largest-factor]
    (if (is-evenly-divisible? candidate factors)
      candidate
      (recur (+ candidate largest-factor)))))

(println (get-smallest-evenly-divisible-number (range 1 21) 20))
  
