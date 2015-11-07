(ns git-coin.target-test
  (:require [clojure.test :refer :all]
            [git-coin.target :refer :all]))


(def max-target 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF)
(def min-target 0)

(deftest test-current-target
  (is (and (>= (current-target) min-target)
           (<= (current-target) max-target))))

(deftest test-calculating-next-target
  )
