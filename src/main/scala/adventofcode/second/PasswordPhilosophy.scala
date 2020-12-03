package adventofcode.second


object PasswordPhilosophy {

  def countValidPassswords(inputs: List[String]): Int =
    inputs
      .map(PasswordParser.parse)
      .filter(_.isValid)
      .size

  def countValidPassswordsPart2(inputs: List[String]): Int =
    inputs
      .map(PasswordParser.parse)
      .filter(_.isValidPart2)
      .size
}
