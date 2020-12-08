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
      day01 _,
      day02 _,
      day03 _,
      day04 _,
      day05 _,
      day06 _
    )
    dailyResults.zipWithIndex.foreach {
      case (dayFn, index) => {
        val dayIndex = index + 1
        val inputs = loadInput("day" + "%02d".format(dayIndex) + ".txt")
        val dayResult = dayFn.apply(inputs)
        printDailyResult(dayIndex, dayResult)
      }
    }

    println("\n---- Finish AdventOfCode 2020 -----")
  }

  private def printDailyResult(dayNumber: Int, results: List[Any]) = {
    println(s"\n--- Day $dayNumber ---")
    println(results.map(_.toString).mkString("\n"))
  }

  private def day01(inputs: List[String]) = {
    List(
      ExpenseReport.calculate(inputs),
      ExpenseReport.calculateTriple(inputs)
    )
  }

  private def day02(inputs: List[String]) = {
    List(
      PasswordPhilosophy.countValidPassswords(inputs),
      PasswordPhilosophy.countValidPassswordsPart2(inputs)
    )
  }

  private def day03(inputs: List[String]) = {
    val treeGrid = TreeGrid.create(inputs)
    List(
      treeGrid.countTreeWhileTraversing(),
      treeGrid.countTreePartTwo()
    )
  }

  private def day04(inputs: List[String]) = {
    List(
      PassportControl.countValidPassports(inputs)
    )
  }

  private def day05(inputs: List[String]) = {
    List(
      BoardingPassScanner.highestSeatId(inputs),
      BoardingPassScanner.findYourSeat(inputs)
    )
  }

  private def day06(inputs: List[String]) = {
    List(
      CustomDeclarationForm.sumAllYesAnswersByAnyone(inputs),
      CustomDeclarationForm.sumAllYesAnswerByEveryone(inputs)
    )
  }

  private def loadInput(fileName: String): List[String] = {
    val relativePath = s"puzzleinputs/$fileName"
    Source.fromResource(relativePath).getLines().toList
  }
}
