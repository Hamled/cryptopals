(ns cryptopals.set-1.challenge-6
  (:require [cryptopals.core :refer :all]
            [cryptopals.lang :refer [score-text-english-simple]]
            [clojure.math.combinatorics :refer [cartesian-product]]))

(def compare-blocks 5)
(def key-size-max 64)

(defn hamming-normalize
  "Normalized hamming distance for two blocks"
  [a b]
  (/ (byte-hamming a b) (count a)))

(defn hamming-average
  "Average normalized hamming distance for the given block size"
  [block-size text]
  (let [block-count (int (Math/floor (/ (count text) block-size)))
        hamming-nums (for [n (range (dec block-count))]
                       (let [block-1 (->> text
                                         (drop (* n block-size))
                                         (take block-size))
                             block-2 (->> text
                                         (drop (* (inc n) block-size))
                                         (take block-size))]
                         (hamming-normalize block-1 block-2)))]
    (/ (reduce + hamming-nums) block-count)))

(defn find-key-sizes
  "Find the most likely key-sizes for a given ciphertext (as byte array)."
  [ciphertext]
  ; Take the top key-sizes with the lowest average hamming distance
  (take 16 (sort-by last <
                    (for [key-size (range 2 key-size-max)]
                      [key-size (hamming-average key-size
                                                 (take (* key-size compare-blocks)
                                                       ciphertext))]))))

(defn decrypt-bytes
  "Decrypt a given byte array with a given key."
  [ciphertext keytext]
  (byte-xor ciphertext keytext))

(defn score-bytes
  "Score a given byte array for its likelihood of being plaintext."
  [plaintext]
  (score-text-english-simple plaintext))

(defn block-scores
  "Get the language analysis scores for each possible key for a given block."
  [block]
  (map (fn [key-byte]
         (let [key-size (count block)
               keytext (byte-array (repeat key-size key-byte))]
           (vector key-byte (score-bytes (decrypt-bytes block keytext)))))
       (range 256)))

(defn find-keys
  "Find the most likely keys for a given key-size."
  [ciphertext key-size]
  (let [cipher-size (count ciphertext)
        scoring-blocks (partition (int (Math/ceil (/ cipher-size key-size)))
                                  (apply interleave (partition key-size
                                                               key-size
                                                               ; Pad with NULL bytes
                                                               (repeat (byte 0))
                                                               ciphertext)))
        block-scores (map #(take 2 (sort-by last > (block-scores %)))
                          scoring-blocks)
        top-scores (take 2 (sort-by #(reduce + (map second %)) >
                                    (apply cartesian-product block-scores)))]
    (map #(byte-array (map first %)) top-scores)))
