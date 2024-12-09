package com.tcsw.aoc

object dayThree {
  private val exampleSource = "src/main/resources/3/example_input.txt"
  private val actualSource = "src/main/resources/3/actual_input.txt"

  private val source = scala.io.Source.fromFile(actualSource)
  private val rawLines = try source.getLines().mkString finally source.close()

  private val mulPattern = """mul\((\d+),(\d+)\)""".r

  def partOne() =
    val sum: Int = mulPattern.findAllMatchIn(rawLines)
      .map { m =>
        val num1 = m.group(1).toInt
        val num2 = m.group(2).toInt
        num1 * num2
      }
      .sum
    print(sum)
}