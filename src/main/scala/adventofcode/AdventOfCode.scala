package adventofcode

import scala.io.Source
import adventofcode.first.ExpenseReport
import adventofcode.second.PasswordPhilosophy
import adventofcode.third.TreeGrid
import adventofcode.fourth.PassportControl
import adventofcode.fifth.BoardingPassScanner
import adventofcode.sixth.CustomDeclarationForm

object AdventOfCode {
  def main(args: Array[String]): Unit = {
    val dailyResults = List(
      day01,
      day02,
      day03,
      day04,
      day05,
      day06
    )
    dailyResults.zipWithIndex.foreach { case (dailyResult, index) => printDailyResult(index + 1, dailyResult) }

    println("\n---- Finish AdventOfCode 2020 -----")
  }

  private def printDailyResult(dayNumber: Int, results: List[Any]) = {
    println(s"\n--- Day $dayNumber ---")
    println(results.map(_.toString).mkString("\n"))
  }

  private def day01() = {
    val inputs = loadInput("day01.txt").map(_.toInt).toList
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

  private def day03() = {
    val inputs = loadInput("day03.txt").toList
    val treeGrid = TreeGrid.create(inputs)
    List(
      treeGrid.countTreeWhileTraversing(),
      treeGrid.countTreePartTwo()
    )
  }

  private def day04() = {
    val inputs = loadInput("day04.txt").toList
    List(
      PassportControl.countValidPassports(inputs)
    )
  }

  private def day05() = {
    val inputs = loadInput("day05.txt").toList
    List(
      BoardingPassScanner.highestSeatId(inputs),
      BoardingPassScanner.findYourSeat(inputs)
    )
  }

    private def day06() = {
    val inputs = loadInput("day06.txt").toList
    List(
      CustomDeclarationForm.sumAllYesAnswersByAnyone(inputs),
      CustomDeclarationForm.sumAllYesAnswerByEveryone(inputs),
    )
  }

  private def loadInput(fileName: String): Iterator[String] = {
    val relativePath = s"puzzleinputs/$fileName"
    Source.fromResource(relativePath).getLines()
  }
}
