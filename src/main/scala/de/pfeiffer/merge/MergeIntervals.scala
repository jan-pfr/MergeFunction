package de.pfeiffer.merge

import scala.collection.mutable.ArrayBuffer

object MergeIntervals {

  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    // Input validation
    require(intervals.length > 0, "List must have at least 1 entry")
    require(intervals.forall(interval => interval.length == 2), "Intervals must have a Start and End")
    require(intervals.forall(interval => interval(0) < interval(1)), "The start of the interval must be greater than the end")
    
    var mergedList = ArrayBuffer[Array[Int]]()

    // iterate over sorted Array
    for (interval <- mergeSort(intervals)) {
      if (mergedList.isEmpty || mergedList.last(1) < interval(0)) {
        mergedList.append(interval)
      } else {
        val tempInterval = checkAndMergeIntervals(interval, mergedList.last)
        mergedList.remove(mergedList.indexOf(mergedList.last))
        mergedList.append(tempInterval)
      }
    }
    return mergedList.distinct.toArray
  }

  //Performing a Mergesort, ascending by beginning of intervals
  def mergeSort(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    if (intervals.length > 1) {
      val mid = (intervals.length / 2).toInt
      var (left, right) = intervals.splitAt(mid)
      left = mergeSort(left)
      right = mergeSort(right)
      return combine(left, right)
    }
    else {
      return intervals
    }
  }
  
  // combine two arrays of intervals, ascending
  def combine(left: Array[Array[Int]], right: Array[Array[Int]]): Array[Array[Int]] = {
    var newList = new ArrayBuffer[Array[Int]]()
    var indexLeft = 0
    var indexRight = 0
    while (indexLeft < left.length && indexRight < right.length) {
      if (left(indexLeft)(0) < right(indexRight)(0)) {
        newList += left(indexLeft)
        indexLeft += 1
      } else {
        newList += right(indexRight)
        indexRight += 1
      }
    }
    while (indexLeft < left.length) {
      newList += left(indexLeft)
      indexLeft += 1
    }
    while (indexRight < right.length) {
      newList += right(indexRight)
      indexRight += 1
    }
    return newList.toArray
  }


  def checkAndMergeIntervals(a: Array[Int], b: Array[Int]): Array[Int] = {
    // checks if a and b are overlapping or the same
    if (a(0) <= b(0) && b(0) <= a(1) && a(1) <= b(1)) {
      return Array(a(0), b(1))
    } else if (b(0) <= a(0) && a(0) <= b(1) && b(1) <= a(1)) {
      return Array(b(0), a(1))
    }
    // checks if a or b contain each other
    else if (a(0) >= b(0) && b(1) >= a(1)) {
      return b
    } else {
      return a
    }
  }

}
