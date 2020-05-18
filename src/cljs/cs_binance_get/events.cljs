(ns cs-binance-get.events
  (:require
   [re-frame.core :as re-frame]
   [cs-binance-get.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
