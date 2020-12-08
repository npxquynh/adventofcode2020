package adventofcode.fourth

import org.scalatest.matchers.should.Matchers._
import org.scalatest.flatspec.AnyFlatSpec
import scala.io.Source

class PassportParserSpec extends AnyFlatSpec {
  "parse" should "return Passport for valid input" in {
    val validInput = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
    val passport = PassportParser.parse(validInput)

    passport.get should equal(
      Passport("1937","2017","2020","183cm","#fffffd","gry","860033327",Some("147"))
    )
  }

  it should "returns passport without countryId as valid" in {
    val validInputWithoutCountryId = "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm"
    PassportParser.parse(validInputWithoutCountryId).get should equal(
      Passport("1931","2013","2024","179cm","#ae17e1","brn","760753108",None)
    )
  }

  it should "returns None for invalid input" in {
    val invalidInput = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929"
    PassportParser.parse(invalidInput) should equal(None)
  }

  it should "returns None when height is invalid" in {
    val invalidHeightInput = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183"
    PassportParser.parse(invalidHeightInput) should equal(None)
  }

  it should "returns None when hair color is invalid" in {
    val invalidHairColorInput = "ecl:gry pid:860033327 eyr:2020 hcl:xxx byr:1937 iyr:2017 cid:147 hgt:183cm"
    PassportParser.parse(invalidHairColorInput) should equal(None)
  }

  it should "returns None when eye color is invalid" in {
    val invalidEyeColorInput = "ecl:xxx pid:860033327 eyr:2020 hcl:#ff00dd byr:1937 iyr:2017 cid:147 hgt:183cm"
    PassportParser.parse(invalidEyeColorInput) should equal(None)
  }

  it should "returns None when passport id is invalid" in {
    val invalidPassportIdInput = "ecl:brn pid:xxx eyr:2020 hcl:#ff00dd byr:1937 iyr:2017 cid:147 hgt:183cm"
    PassportParser.parse(invalidPassportIdInput) should equal(None)
  }
}
