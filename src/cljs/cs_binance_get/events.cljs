(ns cs-binance-get.events
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [re-frame.core :as re-frame]
   [cs-binance-get.db :as db]
   [cljs-http.client :as http]
   [cljs.core.async :as async]
   [cs-binance-get.config :as config]
   ))

(defonce timer (js/setInterval (fn [] (re-frame/dispatch [:timer])) config/fetch-interval))

(re-frame/reg-event-db
  :timer
  (fn [db _]
    (when config/debug? (prn "db: " db))
    (async/take! (http/get "https://api.binance.com/api/v3/ticker/price"
                     {:with-credentials? false
                      :timeout config/req-timeout
                      :query-params {"symbol" config/pair-to-get}}) 
           (fn [response] (re-frame/dispatch [:process_request response])))
    db))

(re-frame/reg-event-db
  :process_request
  (fn [db [_ response]]
     ;(when config/debug? (prn "response: " response))
     (if (= (:error-code response) :no-error) 
       (let [price (:price (js->clj (:body response)))]
         (db/add_result db config/pair-to-get price))
       db)))

(re-frame/reg-event-db
  ::initialize-db
  (fn [_ _]
    db/default-db))
