(ns cryptopals.core-test
  (:require [clojure.test :refer :all]
            [cryptopals.core :refer :all])
  (:import [java.util Arrays]))

(def test-hex "0123456789abcdefdeadbeefdeadbeefdeadbeefdeadbeef")
(def test-bytes (byte-array [0 1 78 127 -1 -127 -78 37 19 64 -64]))

(deftest hex-conversion
  (testing "decoding -> encoding round trip"
    (= test-hex (encode-hex (decode-hex test-hex))))
  (testing "encoding -> decoding round trip"
    (Arrays/equals test-bytes (decode-hex (encode-hex test-bytes)))))
