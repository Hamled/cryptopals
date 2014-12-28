(ns cryptopals.set-1.challenge-3
  (:require [cryptopals.core :refer :all]
            [cryptopals.lang :refer [char-freq-english
                                     score-text-english-simple]])
  (:import [org.apache.commons.codec.binary StringUtils]))

(defn find-plaintext
  "Find the plaintext for a given hex encoded XOR'd ciphertext."
  [cipher-hex]
  (let [cipher-bytes (decode-hex cipher-hex)
        cipher-len (count cipher-bytes)
        keys-bytes (map #(byte-array (repeat cipher-len %)) (range 256))
        plaintexts (map #(StringUtils/newStringUtf8 %) (map #(byte-xor cipher-bytes %) keys-bytes))
        scores (sort-by first > (map #(vector (score-text-english-simple %) %) plaintexts))]
    (take 10 scores)))
