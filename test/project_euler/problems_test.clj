(ns project-euler.problems-test
  (:require [clojure.test :refer :all]
            [project-euler.problems.1 :as problem1]
            [project-euler.problems.2 :as problem2]
            [project-euler.problems.3 :as problem3]
            [project-euler.problems.4 :as problem4]
            [project-euler.problems.5 :as problem5]
            [project-euler.problems.6 :as problem6]
            [project-euler.problems.7 :as problem7]
            [project-euler.problems.8 :as problem8]
            [project-euler.problems.9 :as problem9]
            [project-euler.problems.10 :as problem10]))

(deftest problem-1
  (testing "Correct solution for Problem 1"
    (is (= problem1/solution 233168))))

(deftest problem-2
  (testing "Correct solution for Problem 2"
    (is (= problem2/solution 4613732))))

(deftest problem-3
  (testing "Correct solution for Problem 3"
    (is (= problem3/solution 6857))))

(deftest problem-4
  (testing "Correct solution for Problem 4"
    (is (= problem4/solution 906609))))

(deftest problem-5
  (testing "Correct solution for Problem 5"
    (is (= problem5/solution 232792560))))

(deftest problem-6
  (testing "Correct solution for Problem 6"
    (is (= problem6/solution 25164150))))

(deftest problem-7
  (testing "Correct solution for Problem 7"
    (is (= problem7/solution 104743))))

(deftest problem-8
  (testing "Correct solution for Problem 8"
    (is (= problem8/solution 23514624000))))

(deftest problem-9
  (testing "Correct solution for Problem 9"
    (is (= problem9/solution 31875000))))

(deftest problem-10
  (testing "Correct solution for Problem 10"
    (is (= problem10/solution 142913828922))))
