(ns cryptopals.core
  (:require [clj-fuzzy.metrics :refer  [hamming]])
  (:import [org.apache.commons.codec.binary Hex StringUtils BinaryCodec]))

;; Hex conversion
(defn decode-hex
  "Decode a string of hexadecimal values into a byte array."
  [hex]
  (Hex/decodeHex (char-array hex)))

(defn encode-hex
  "Encode a byte array into a string of hexadecimal values."
  [byte-values]
  (apply str (Hex/encodeHex byte-values true)))

(defn decode-string
  "Decode a string of hexadecimal values into a UTF-8 string."
  [hex]
  (StringUtils/newStringUtf8 (decode-hex hex)))

(defn encode-string
  "Encode a UTF-8 text string into a string of hexadecimal values."
  [string]
  (encode-hex (StringUtils/getBytesUtf8 string)))


;; Bitwise operations on byte arrays
(defn byte-xor
  "Bitwise XOR on each byte of two arrays."
  [x y]
  (byte-array (map bit-xor x y)))

(defn byte-hamming
  "Hamming distance (in bits) between two byte arrays."
  [x y]
  (hamming (BinaryCodec/toAsciiString x) (BinaryCodec/toAsciiString y)))
