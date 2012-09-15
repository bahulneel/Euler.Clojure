(defn get-digits [number]
  (map #(Integer/parseInt (str %)) (seq (str number))))

(defn is-palindrome? [collection]
  (let [size (count collection) half-size (/ size 2)]
    (loop [index 0 answer true]
      (if (and answer (< index half-size))
        (recur (+ index 1) (= (nth collection index) (nth collection (- (- size 1) index))))
        answer))))

(defn get-greatest-palindrome-product [first-factor second-factor-limit]
  (loop [second-factor second-factor-limit]
    (let [product (* first-factor second-factor)]
      (if (is-palindrome? (get-digits product))
        product
        (recur (- second-factor 1))))))

(let [limit 999]
  (loop [factor limit greatest-palindrome 0]
    (if (> factor 0)
      (let [palindrome (get-greatest-palindrome-product factor factor)]
        (if (> palindrome greatest-palindrome)
          (recur (- factor 1) palindrome)
          (recur (- factor 1) greatest-palindrome)))
      (println greatest-palindrome))))

