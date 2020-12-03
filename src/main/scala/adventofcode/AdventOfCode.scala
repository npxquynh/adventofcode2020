package adventofcode

import scala.io.Source
import adventofcode.first.ExpenseReport
import adventofcode.second.PasswordPhilosophy

object AdventOfCode {
  def main(args: Array[String]): Unit = {
    val dailyResults = List(
      day01,
      day02
    )
    dailyResults.zipWithIndex.foreach { case (dailyResult, index) => printDailyResult(index + 1, dailyResult) }

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

  private def day02() = {
    val inputs = loadInput("day02.txt").toList

    List(
      PasswordPhilosophy.countValidPassswords(inputs),
      PasswordPhilosophy.countValidPassswordsPart2(inputs)
    )
  }

  private def loadInput(fileName: String): Iterator[String] = {
    val relativePath = s"puzzleinputs/$fileName"
    Source.fromResource(relativePath).getLines()
  }
}
