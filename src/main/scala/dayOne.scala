package com.tcsw.aoc

class dayOne

val exampleSource = "src/main/resources/1/example_input.txt"
val step1Source = "src/main/resources/1/step1.txt"

def solveDayOne(): Unit =
  val source = scala.io.Source.fromFile(step1Source)
  val lines = try source.getLines() mkString "\n" finally source.close()

  val numbersWithIndexes = lines
    .filter(line => line.isDigit)
    .map(_.asDigit)
    .toList
    .zipWithIndex

  val (leftListWithIndexes, rightListWithIndexes) = numbersWithIndexes
    .partition((_, index) => index % 2 == 0)

  val leftListOrdered = leftListWithIndexes.map(_._1).sorted
  val rightListOrdered = rightListWithIndexes.map(_._1).sorted

  val sumOfDifferences = leftListOrdered
    .zip(rightListOrdered)
    .map((leftNumber, rightNumber) =>  rightNumber - leftNumber)
    .sum

  print(sumOfDifferences)
