(ns cryptopals.core
  (:import (org.apache.commons.codec.binary Hex)))

(defn decode-hex
  "Decode a string of hexadecimal values into a byte array."
  [hex]
  (Hex/decodeHex (char-array hex)))

(defn encode-hex
  "Encode a byte array into a string of hexadecimal values."
  [byte-values]
  (apply str (Hex/encodeHex byte-values true)))
