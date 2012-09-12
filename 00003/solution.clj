(defn is-factor? [product candidate]
  (= (rem product candidate) 0))

(defn get-largest-prime-factor [product candidate]
  (if (> candidate (int (Math/sqrt product)))
    product
    (if (= product candidate)
      product
      (if (is-factor? product candidate)
        (recur (/ product candidate) candidate)
        (recur product (+ candidate 1))))))

(println (get-largest-prime-factor 600851475143 2))

