package adventofcode.second

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class PassswordParserSpec extends AnyFlatSpec {
  ".parse" should "creates RuleAndPassword instance for valid inputs" in {
    val inputs = List(
      "1-3 a: abcde",
      "1-3 b: cdefg",
      "2-9 c: ccccccccc",
      "1-3 d: "
    )
    val parsedResult = List(
      RuleAndPassword(1, 3, 'a', "abcde"),
      RuleAndPassword(1, 3, 'b', "cdefg"),
      RuleAndPassword(2, 9, 'c', "ccccccccc"),
      RuleAndPassword(1, 3, 'd', "")
    )
    inputs.map(PasswordParser.parse) should be(parsedResult)
  }

  it should "throws error for invalid inputs" in {
    val invalidInputs = List(
      "1-3 d:"
    )

    invalidInputs.foreach { invalidInput =>
      an[RuntimeException] should be thrownBy (PasswordParser.parse(
        invalidInput
      ))
    }
  }
}
