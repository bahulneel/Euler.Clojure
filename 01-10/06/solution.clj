(use 'clojure.math.numeric-tower)

(defn get-sum-of-squares [numbers]
  (reduce #(+ %1 (expt %2 2)) numbers))

(defn get-square-of-sums [numbers]
  (expt (reduce + numbers) 2))

(defn get-square-of-sums-minus-sum-of-squares [start end]
  (let [numbers (range start (+ end 1))]
    (- (get-square-of-sums numbers) (get-sum-of-squares numbers))))

(println (get-square-of-sums-minus-sum-of-squares 1 100))

