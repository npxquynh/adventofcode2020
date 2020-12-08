package adventofcode.fourth

import org.scalatest.matchers.should.Matchers._
import org.scalatest.flatspec.AnyFlatSpec
import scala.io.Source

class PassportControlSpec extends AnyFlatSpec {
  "countValidPassports" should "returns the number of valid passports" in {
    val rawInputs = Source.fromResource("./day04.txt").getLines().toList
    PassportControl.countValidPassports(rawInputs) should equal(2)
  }

  it should "returns 0 when counting all invalid passports" in {
    val rawInputs =
      Source.fromResource("./day04_invalid_passports.txt").getLines().toList
    PassportControl.countValidPassports(rawInputs) should equal(0)
  }

  it should "returns 4 when counting all valid passports" in {
    val rawInputs =
      Source.fromResource("./day04_valid_passports.txt").getLines().toList
    PassportControl.countValidPassports(rawInputs) should equal(4)
  }
}
