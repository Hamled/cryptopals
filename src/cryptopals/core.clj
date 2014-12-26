(ns cryptopals.core)

(defn hex-to-byte
  "Convert up to two hex characters into a byte."
  [hex]
  (if (> (count hex) 2)
    (throw (IllegalArgumentException. "More than two hexadecimal characters cannot be converted to a byte."))
    (Integer/parseInt (apply str hex) 16)))

(defn hex-to-byte-array
  "Convert a string of hex into a byte array."
  [hex]
  (if (odd? (count hex))
    (hex-to-byte-array (str \0 (apply str hex)))
    (byte-array (map hex-to-byte (partition 2 hex)))))
