(ns cryptopals.set-1.challenge-5-test
  (:require [clojure.test :refer :all]
            [cryptopals.core :refer :all]
            [cryptopals.set-1.challenge-5 :refer [repeating-key-encrypt]]))

(def plaintext "Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal")
(def ciphertext-hex (str "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272"
                         "a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f"))
(def keytext "ICE")

(deftest implement-repeating-key-XOR
  (testing "Here is the opening stanza of an important work of the English language:
              Burning 'em, if you ain't quick and nimble
              I go crazy when I hear a cymbal
           Encrypt it, under the key 'ICE', using repeating-key XOR.
           In repeating-key XOR, you'll sequentially apply each byte of the key; the first byte of plaintext will be XOR'd against I, the next C, the next E, then I again for the 4th byte, and so on.
           It should come out to:
              0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272
              a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f"
    (is (= ciphertext-hex
           (encode-hex (repeating-key-encrypt plaintext keytext))))))
