(ns cs-binance-get.db
  (:require
    [cs-binance-get.config :as config]))

(def default-db {})

(defn add_result [db pair price]
  (let [stime (js/Date)]
    (update db pair (fn [pair_data]
                      (map (fn [_ x] x) (range 0 config/db-length) (cons [stime price] pair_data))))))


