package adventofcode.first

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ExpenseReportSpec extends AnyFlatSpec with Matchers {
    "calculate" should "multiply numbers that equal zero" in {
      val inputs = List(1721, 979, 366, 299, 675, 1456).map(_.toString())
      ExpenseReport.calculate(inputs) shouldEqual(Some(514579))
    }

  "calculateTriplet" should "multiply 3 numbers that summing up to 2020" in {
      val inputs = List(1721, 979, 366, 299, 675, 1456).map(_.toString())
      ExpenseReport.calculateTriple(inputs) shouldEqual(Some(241861950))
  }
}
