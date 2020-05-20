(ns cs-binance-get.config)

(def req-timeout 5000)
(def fetch-interval 10000)
(def pair-to-get "BTCUSDT")
(def db-length 500)

(def debug?
  ^boolean goog.DEBUG)
