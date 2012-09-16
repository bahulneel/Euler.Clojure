(use 'clojure.math.numeric-tower)

(println
  (loop [a 1 b 2]
    (let [c (sqrt (+ (* a a) (* b b)))]
      (if (= (+ a b c) 1000)
        (* a b c)
        (if (< b 998)
          (recur a (+ b 1))
          (recur (+ a 1) (+ a 2)))))))

