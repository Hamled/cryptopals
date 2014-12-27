(ns cryptopals.set-1.challenge-1-test
  (:require [clojure.test :refer :all]
            [cryptopals.core :refer :all])
  (:import [org.apache.commons.codec.binary Base64]))

(deftest convert-hex-to-base64
  (testing "The string:
              49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d
            should produce:
              SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"
    (is (= "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"
           (Base64/encodeBase64String (decode-hex
              "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"))))))
