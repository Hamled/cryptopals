(ns cryptopals.core)

(defn hex-to-byte
  "Convert up to two hex characters into a byte."
  [hex]
  (if (> (count hex) 2)
    (throw (IllegalArgumentException. "More than two hexadecimal characters cannot be converted to a byte."))
    (Integer/parseInt (apply str hex) 16)))
