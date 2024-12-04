package com.tcsw.aoc

object dayTwo {

  private val exampleSource = "src/main/resources/2/example_input.txt"
  private val actualSource = "src/main/resources/2/actual_input.txt"
  
  private val source = scala.io.Source.fromFile(actualSource)
  private val rawLines = try source.getLines().toList finally source.close()
  
  def partOne(): Unit =
    val safeReportsCount = rawLines
      .map(line => lineToIntList(line))
      .count(list => isDistinct(list)
        && isDifferentByAtMostThree(list)
        && (isOrderedAsc(list) || isOrderedDesc(list))
      )

    print(safeReportsCount)

  private def lineToIntList(line: String) =
    line.split(' ').map(_.toInt)

  private def isOrderedDesc(list: Array[Int]) =
    list sameElements list.sorted(Ordering[Int].reverse)

  private def isOrderedAsc(list: Array[Int]) =
    list sameElements list.sorted

  private def isDistinct(list: Array[Int]) =
    list sameElements list.distinct

  private def isDifferentByAtMostThree(list: Array[Int]) =
  // Sliding groups the array into overlapping sub-arrays of size 2 (adjacent pairs).
   list.sliding(2).forall {
      case Array(a, b) => (a - b).abs <= 3
      case _ => true // Handle edge cases like single-element arrays
    }
}