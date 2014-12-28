(ns cryptopals.set-1.challenge-4-test
  (:require [clojure.test :refer :all]
            [cryptopals.set-1.challenge-4 :refer [find-plaintext]]))

(def ciphertext-file "resources/set_1/challenge_4/ciphertexts.txt")

(deftest detect-single-character-XOR
  (testing "One of the 60-character strings in [ciphertext-file] has been encrypted by single-character XOR.
           Find it."
    (is (= ["Now that the party is jumping\n"]
           (nfirst (find-plaintext ciphertext-file))))))
