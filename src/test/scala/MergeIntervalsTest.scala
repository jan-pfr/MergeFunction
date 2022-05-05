import de.pfeiffer.merge.MergeIntervals
import org.scalatest.funsuite.AnyFunSuite


class MergeIntervalsTest extends AnyFunSuite {
  test("MergeIntervals.checkOverlappingIntervals"){
    assert(MergeIntervals.checkAndMergeIntervals(Array(3,8), Array(2,5))=== Array(2,8))
    assert(MergeIntervals.checkAndMergeIntervals(Array(1,6), Array(2,18))=== Array(1,18))
  }
  test("MergerIntervals.checkIncludingIntervals"){
    assert(MergeIntervals.checkAndMergeIntervals(Array(6,8), Array(5,9))=== Array(5,9))
    assert(MergeIntervals.checkAndMergeIntervals(Array(3,4), Array(2,5))=== Array(2,5))
  }
  test("MergeIntervals.checkMerge"){
    assert(MergeIntervals.merge(Array(Array(4,7))) === Array(Array(4,7)))
    assert(MergeIntervals.merge(Array(Array(25,30),Array(2,19), Array(14,23), Array(4,8))) === Array(Array(2,23), Array(25,30)))
    }
  test("MergeIntervals.checkInputValidation"){
    assertThrows[IllegalArgumentException] {
      MergeIntervals.merge((Array()))
    }
    assertThrows[IllegalArgumentException]{
      MergeIntervals.merge(Array(Array(1), Array(1,4)))
    }
    assertThrows[IllegalArgumentException]{
      MergeIntervals.merge(Array(Array(5,2), Array(10,9)))
    }
  }
  test("MergeIntervals.checkMergSort"){
    assert(MergeIntervals.mergeSort(Array(Array(4,6),Array(1,13), Array(56,77), Array(12,44))) === Array(Array(1,13), Array(4,6), Array(12,44), Array(56,77)))
  }
  test("MergerIntervals.checkCombine"){
    val left = Array(Array(7, 9))
    val right = Array(Array(12,77), Array(14,55))
    assert(MergeIntervals.combine(left, right) === Array(Array(7,9), Array(12, 77), Array(14,55)))
  }
  }

