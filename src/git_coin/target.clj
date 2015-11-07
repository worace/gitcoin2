(ns git-coin.target)

(defonce target (atom 0))

(defn current-target []
  @target)


;; Calculating next target
;;

(defn next-target
  "Adjusts previous target based on time spread of recent blocks."
  [last-blocks previous-target desired-spacing]
  )
