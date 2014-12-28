(ns cryptopals.set-1.challenge-4
  (:require [cryptopals.core :refer :all]
            [clojure.java.io :as io]
            [cryptopals.lang :refer [char-freq-english
                                     score-text-english-simple]]))

(defn find-single-plaintext
  "Find the plaintext for a given hex encoded XOR'd ciphertext."
  [cipher-hex]
  (let [cipher-bytes (decode-hex cipher-hex)
        cipher-len (count cipher-bytes)
        keys-bytes (map #(byte-array (repeat cipher-len %)) (range 256))
        plains-bytes (map #(byte-xor cipher-bytes %) keys-bytes)
        plains-chars (map #(map (fn [c] (char (bit-and c 255))) %) plains-bytes)
        plaintexts (map #(apply str %) plains-chars)
        scores (sort-by first > (map #(vector (score-text-english-simple %) %) plaintexts))]
    (take 10 scores)))

(defn find-plaintext
  "Find the plaintext in a given file with a set of ciphertexts, one per line."
  [cipher-file]
  (with-open [rdr (io/reader cipher-file)]
    (let [lines (line-seq rdr)
          plaintexts (sort-by first > (partition 2 (flatten (map find-single-plaintext lines))))]
      (take 10 plaintexts))))
