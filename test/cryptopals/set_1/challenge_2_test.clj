(ns cryptopals.set-1.challenge-2-test
  (:require [clojure.test :refer :all]
            [cryptopals.core :refer :all]))

(deftest fixed-XOR
  (testing "If your function works properly, then when you feed it the string:
              1c0111001f010100061a024b53535009181c
            ... after hex decoding, and when XOR'd against:
              686974207468652062756c6c277320657965
            ... should produce:
              746865206b696420646f6e277420706c6179"
    (= "746865206b696420646f6e277420706c6179"
       (encode-hex (byte-xor
                     (decode-hex "1c0111001f010100061a024b53535009181c")
                     (decode-hex "686974207468652062756c6c277320657965"))))))
