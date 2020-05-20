(ns cs-binance-get.subs
  (:require
    [cs-binance-get.config :as config]
    [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::pair
 (fn [db [_ pair_name]] 
   (db pair_name)))
