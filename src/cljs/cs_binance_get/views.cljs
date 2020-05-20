(ns cs-binance-get.views
  (:require
   [re-frame.core :as re-frame]
   [cs-binance-get.config :as config]
   [cs-binance-get.subs :as subs]
   ))

(defn main-panel []
  (let [data (map (fn [[k v]] [:tr {:key k} [:td k] [:td v]]) @(re-frame/subscribe [::subs/pair config/pair-to-get]))]
    ;(when config/debug? (prn "got: " data))
    [:table {:width "100%"} [:thead [:b (str config/pair-to-get " rate")] [:tbody data ]]]))
