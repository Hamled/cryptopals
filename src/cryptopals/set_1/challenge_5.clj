(ns cryptopals.set-1.challenge-5
  (:require [cryptopals.core :refer :all]
            [clojure.java.io :as io])
  (:import [org.apache.commons.codec.binary StringUtils]))

(defn repeating-key-encrypt
  "Encrypt a given plaintext with XOR using a keytext, repeated for the length of the plaintext."
  [plaintext keytext]
  (let [key-repeats (Math/ceil (/ (count plaintext) (count keytext)))
        keytext (apply str (take (count plaintext)
                                  (apply str (repeat key-repeats keytext))))
        plain-bytes (StringUtils/getBytesUtf8 plaintext)
        key-bytes (StringUtils/getBytesUtf8 keytext)]
    (byte-xor plain-bytes key-bytes)))
