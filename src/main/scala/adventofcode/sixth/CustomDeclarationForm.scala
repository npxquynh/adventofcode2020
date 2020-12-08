package adventofcode.sixth

import adventofcode.Utils

object CustomDeclarationForm {
  def sumAllYesAnswersByAnyone(rawInputs: List[String]): Int = {
    val forms = Utils.splitByBlankLines(rawInputs, delimiter = "")
    forms.map(countYesAnswerByAnyone).sum
  }

  def sumAllYesAnswerByEveryone(rawInputs: List[String]): Int = {
    val forms = Utils.splitByBlankLines(rawInputs, delimiter = " ")
    forms.map(countYesAnswerByEveryone).sum
  }

  private def countYesAnswerByAnyone(form: String): Int = form.toSet.size

  private def countYesAnswerByEveryone(form: String): Int = {
    val totalPeople = form.split(" ").size

    // TODO: immutable map might not be efficient
    val alphabets = 'a' to 'z'
    val answersEveryoneSaysYesTo = alphabets.map { char =>
      (char, form.count(_ == char))
    }.filter { case (char, count) => count == totalPeople }

    answersEveryoneSaysYesTo.size
  }
}
