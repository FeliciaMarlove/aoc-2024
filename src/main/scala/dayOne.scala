package com.tcsw.aoc

class dayOne

val exampleSource = "src/main/resources/1/example_input.txt"
val step1Source = "src/main/resources/1/step1.txt"

def solveDayOne(): Unit =
  val source = scala.io.Source.fromFile(step1Source)
  val lines = try source.getLines().toList finally source.close()

  val (leftNumbers, rightNumbers) = lines.map { line =>
    val pair = line.split("\\s+")
    (pair(0).toInt, pair(1).toInt)
  }.unzip

  val sumOfDifferences = leftNumbers.sorted
    .zip(rightNumbers.sorted)
    .map((leftNumber, rightNumber) =>  (rightNumber - leftNumber).abs)
    .sum

  print(sumOfDifferences)
