package adventofcode.sixth

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class CustomDeclarationFormSpec extends AnyFlatSpec {
  val inputs = """
abc

a
b
c

ab
ac

a
a
a
a

b""".split("\n").toList

  "sumAllYesAnswersByAnyone" should "returns correct result" in {
    CustomDeclarationForm.sumAllYesAnswersByAnyone(inputs) should equal(11)
  }

  "sumAllYesAnswersByEveryone" should "returns correct result" in {
    CustomDeclarationForm.sumAllYesAnswerByEveryone(inputs) should equal(6)
  }

}
