package adventofcode

object Utils {
  def splitByBlankLines(rawInputs: List[String], delimiter: String): List[String] = {
    def helper(inputs: List[String], currentGroupInput: List[String], allGroupInputs: List[String]): List[String] = inputs match {
      case "" :: tail => helper(tail, Nil, currentGroupInput.mkString(delimiter) :: allGroupInputs)
      case head :: tail => helper(tail, currentGroupInput :+ head, allGroupInputs)
      case Nil => return currentGroupInput.mkString(delimiter) :: allGroupInputs
    }

    helper(rawInputs, Nil, Nil).reverse
  }
}
