(ns cs-binance-get.views
  (:require
   [re-frame.core :as re-frame]
   [cs-binance-get.subs :as subs]
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     ]))
