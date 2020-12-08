package adventofcode.fourth

import org.scalatest.matchers.should.Matchers._
import org.scalatest.flatspec.AnyFlatSpec
import scala.io.Source

class PassportControlSpec extends AnyFlatSpec {
  "preprocess" should "returns 4 lines representing 4 passport information from the inputs" in {
    val rawInputs = Source.fromResource("./day04.txt").getLines().toList

    val result = PassportControl.preprocess(rawInputs)
    result should equal(
      List(
        "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm",
        "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929",
        "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm",
        "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in"
      )
    )
  }

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
