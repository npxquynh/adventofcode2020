package adventofcode.fourth

import adventofcode.Utils

object PassportControl {

  def countValidPassports(rawInputs: List[String]): Int = {
    val passportLines = Utils.splitByBlankLines(rawInputs, delimiter = " ")
    passportLines.map(PassportParser.parse(_)).filter(_.isDefined).size
  }
}
