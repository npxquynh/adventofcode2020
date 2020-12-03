package adventofcode.second

case class RuleAndPassword(atLeast: Int, atMost: Int, char: Char, password: String) {
  def isValid(): Boolean = {
    val charCount = password.count(_ == char)
    atLeast <= charCount && charCount <= atMost
  }

  def isValidPart2(): Boolean = {
    val firstPositionContainsChar = password(atLeast - 1) == char
    val secondPositionContainsChar = password(atMost - 1) == char

    (firstPositionContainsChar && !secondPositionContainsChar) || (!firstPositionContainsChar && secondPositionContainsChar)
  }
}
