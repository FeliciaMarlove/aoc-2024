package com.tcsw.aoc

class dayOne

val exampleSource = "src/main/resources/1/example_input.txt"
val step1Source = "src/main/resources/1/step1.txt"

def solveDayOne(): Unit =

  print(partOne())

def partOne() =
  val (firstList, secondList) = getLeftAndRightLists(readFile(step1Source))
  firstList.sorted
    .zip(secondList.sorted)
    .map((leftNumber, rightNumber) =>  (rightNumber - leftNumber).abs)
    .sum

def readFile(sourceFile: String): List[String] =
  val source = scala.io.Source.fromFile(sourceFile)
  val lines = try source.getLines().toList finally source.close()
  lines

def getLeftAndRightLists(lines: List[String]) =
  lines.map { line =>
    val pair = line.split("\\s+")
    (pair(0).toInt, pair(1).toInt)
  }.unzip