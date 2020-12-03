package adventofcode.second

object PasswordParser {
  private val RuleAndPasswordExtractorRE = """\A([\d]+)\-([\d]+) (\w): ([\S]*)\z""".r

  def parse(input: String): RuleAndPassword = input match {
    case RuleAndPasswordExtractorRE(atLeast, atMost, char, password) =>
      RuleAndPassword(atLeast.toInt, atMost.toInt, char(0), password)
    case _ => throw new RuntimeException(s"$input cannot be parsed")
  }
}
