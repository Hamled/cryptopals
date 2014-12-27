(ns cryptopals.core-test
  (:require [clojure.test :refer :all]
            [cryptopals.core :refer :all])
  (:import [java.util Arrays]))

(def test-hex "0123456789abcdefdeadbeefdeadbeefdeadbeefdeadbeef")
(def test-bytes (byte-array [0 1 78 127 -1 -128 -78 37 19 64 -64]))

(deftest hex-conversion
  (testing "decoding -> encoding round trip"
    (is (= test-hex (encode-hex (decode-hex test-hex )))))
  (testing "encoding -> decoding round trip"
    (is (Arrays/equals test-bytes (decode-hex (encode-hex test-bytes))))))

(deftest bitwise-ops
  (testing "XOR on two byte arrays"
    (is (Arrays/equals (byte-array [153 153 102 102]) (byte-xor
                                                        (byte-array [197 58 53 202])
                                                        (byte-array [92 163 83 172]))))))
