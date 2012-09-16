(use '[clojure.string :only (split)])

(defn get-product [values]
  (apply * values))

(defn get-value [grid row column]
  (Integer/parseInt (nth (nth grid row) column)))

(defn get-right [grid row column size]
  (if (> column (- (count (nth grid row)) size))
    [0]
    (map #(Integer/parseInt %) (take size (drop column (nth grid row))))))

(defn get-rightdown [grid row column size]
  (if (> column (- (count (nth grid row)) size))
    [0]
    (loop [i 0 values []]
      (if (= i size)
        values
        (recur (+ i 1) (conj values (get-value grid (+ row i) (+ column i))))))))

(defn get-down [grid row column size]
  (loop [i 0 values []]
    (if (= i size)
      values
      (recur (+ i 1) (conj values (get-value grid (+ row i) column))))))

(defn get-leftdown [grid row column size]
  (if (< column (- size 1))
    [0]
    (loop [i 0 values []]
      (if (= i size)
        values
        (recur (+ i 1) (conj values (get-value grid (+ row i) (- column i))))))))

(defn get-greatest-adjacent-product [grid factor-count]
  (loop [row 0 column 0 greatest-product 0]
    (if (= row (- (count grid) factor-count))
      greatest-product
      (if (= column (count (nth grid row)))
        (recur (+ row 1) 0 greatest-product)
        (let [product-right (get-product (get-right grid row column factor-count))
              product-rightdown (get-product (get-rightdown grid row column factor-count))
              product-down (get-product (get-down grid row column factor-count))
              product-leftdown (get-product (get-leftdown grid row column factor-count))
              product (max product-right product-rightdown product-down product-leftdown)
              next-column (+ column 1)]
          (if (> product greatest-product)
            (recur row next-column product)
            (recur row next-column greatest-product)))))))

(defn read-grid [path]
  (map #(split % #" ") (split (slurp path) #"\n")))

(println (get-greatest-adjacent-product (read-grid "data.txt") 4))

