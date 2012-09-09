(defn sum-even-fibonacci [first second limit total]
  (if (<= second limit)
    (let [new-total (if (= (rem second 2) 0) (+ total second) total)]
      (sum-even-fibonacci second (+ first second) limit new-total))
    total))

(println (sum-even-fibonacci 0 1 4000000 0))

