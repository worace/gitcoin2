(ns git-coin.target-test
  (:require [clojure.test :refer :all]
            [clj-time.core :as time]
            [git-coin.target :refer :all]))


(def max-target 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF)
(def min-target 0)

(deftest test-current-target
  (is (and (>= (current-target) min-target)
           (<= (current-target) max-target))))

(deftest test-spacing
  (is (= 60
         (avg-spacing [(time/date-time 2015 1 1 1 0)
                       (time/date-time 2015 1 1 1 1)
                       (time/date-time 2015 1 1 1 2)]))))

(deftest test-calculating-next-target
  (let [blocks [{:created-at (time/date-time 2015 1 1 1 0)}
                {:created-at (time/date-time 2015 1 1 1 1)}]
        spacing 60]
    (testing "next target when spacing matches up is the same"
      (is (= 1 (next-target blocks 1 spacing))))))
