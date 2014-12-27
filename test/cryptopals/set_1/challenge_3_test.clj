(ns cryptopals.set-1.challenge-3-test
  (:require [clojure.test :refer :all]
            [cryptopals.set-1.challenge-3 :refer [find-plaintext]]))

(def ciphertext-hex "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736")

(deftest single-byte-xor-cipher
  (testing "The hex encoded string:
              1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736
           ... has been XOR'd against a single character. Find the key, decrypt the message."
    (= "Cooking MC's like a pound of bacon"
       (ffirst (find-plaintext ciphertext-hex)))))
