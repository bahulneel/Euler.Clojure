(defn sum-multiples [multiples candidate limit total]
  (if (< candidate limit)
    (let [new-total (if (some #(= (rem candidate %) 0) multiples) (+ candidate total) total)]
      (recur multiples (+ candidate 1) limit new-total))
    total))

(println (sum-multiples [3 5] 1 1000 0))

