package adventofcode.fourth

object PassportControl {
  def preprocess(inputs: List[String]): List[String] = {
    def helper(inputs: List[String], currentPassportLine: List[String], allPassportLines: List[String]): List[String] = inputs match {
      case "" :: tail => helper(tail, Nil, currentPassportLine.mkString(" ") :: allPassportLines)
      case head :: tail => helper(tail, currentPassportLine :+ head, allPassportLines)
      case Nil => return currentPassportLine.mkString(" ") :: allPassportLines
    }

    helper(inputs, Nil, Nil).reverse
  }

  def countValidPassports(rawInputs: List[String]): Int = {
    val passportLines = preprocess(rawInputs)
    passportLines.map(PassportParser.parse(_)).filter(_.isDefined).size
  }
}
