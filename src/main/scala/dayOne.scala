package com.tcsw.aoc

object dayOne {

  private val exampleSource = "src/main/resources/1/example_input.txt"
  private val actualSource = "src/main/resources/1/actual_input.txt"

  def solveDayOne(): Unit =

    val source = scala.io.Source.fromFile(actualSource)
    val lines = try source.getLines().toList finally source.close()
    val (leftList, rightList) = getLeftAndRightLists(lines)

    //print(partOne(leftList, rightList))
    print(partTwo(leftList, rightList))

  def partOne(firstList: List[Int], secondList: List[Int]) =
    firstList.sorted
      .zip(secondList.sorted)
      .map((leftNumber, rightNumber) => (rightNumber - leftNumber).abs)
      .sum

  def partTwo(firstList: List[Int], secondList: List[Int]) =
    firstList.map { a =>
      val countInB = secondList.count(_ == a)
      a * countInB
    }.sum

  def getLeftAndRightLists(lines: List[String]) =
    lines.map { line =>
      val pair = line.split("\\s+")
      (pair(0).toInt, pair(1).toInt)
    }.unzip

}