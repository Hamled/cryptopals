(ns cryptopals.core
  (:import (org.apache.commons.codec.binary Hex)))

;; Hex conversion
(defn decode-hex
  "Decode a string of hexadecimal values into a byte array."
  [hex]
  (Hex/decodeHex (char-array hex)))

(defn encode-hex
  "Encode a byte array into a string of hexadecimal values."
  [byte-values]
  (apply str (Hex/encodeHex byte-values true)))


;; Bitwise operations on byte arrays
(defn byte-xor
  "Bitwise XOR on each byte of two arrays."
  [x y]
  (byte-array (map bit-xor x y)))
