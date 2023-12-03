(ns main
  (:gen-class))

(str "Hello" " " "World")

(defn PartOne []
  (def x [])
  (with-open [rdr (clojure.java.io/reader "../inputs/day_one.txt")]
    (def line (re-seq #"\d" (str (line-seq rdr))))
    (def digits (reduce conj [] [(first line) (last line)]))
    (conj x digits)
    (println x))
  x)


(println (PartOne))