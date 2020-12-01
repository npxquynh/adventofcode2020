package adventofcode

import scala.io.Source
import adventofcode.first.ExpenseReport

object AdventOfCode {
  def main(args: Array[String]): Unit = {
    printDailyResult(1, day01)

    println("\n---- Finish AdventOfCode 2020 -----")
  }

  private def printDailyResult(dayNumber: Int, results: List[Any]) = {
    println(s"\n--- Day $dayNumber ---")
    println(results.map(_.toString).mkString("\n"))
  }

  private def day01() = {
    val inputs = loadInput("day01_1.txt").map(_.toInt).toList

    List(
      ExpenseReport.calculate(inputs),
      ExpenseReport.calculateTriple(inputs)
    )
  }

  private def loadInput(fileName: String): Iterator[String] = {
    val relativePath = s"puzzleinputs/$fileName"
    Source.fromResource(relativePath).getLines()
  }
}
