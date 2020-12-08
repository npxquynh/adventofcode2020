package adventofcode.fourth

object PassportParser {

  private val RequiredFields = Set(
    "byr",
    "iyr",
    "eyr",
    "hgt",
    "hcl",
    "ecl",
    "pid"
  )

  private val ValidEyeColors =
    List("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

  def parse(input: String): Option[Passport] = {
    val inputMapping = input
      .split(" ")
      .map { pair => pair.split(":") }
      .map(p => (p(0), p(1)))
      .toMap

    if (validateRequiredFields(inputMapping.keySet))
      createValidPassport(inputMapping)
    else None
  }

  private def createValidPassport(
      inputMapping: Map[String, String]
  ): Option[Passport] = {
    for {
      birthYear <- inputMapping.get("byr").flatMap(validateBirthYear)
      issueYear <- inputMapping.get("iyr").flatMap(validateIssueYear)
      expirationYear <- inputMapping.get("eyr").flatMap(validateExpirationYear)
      height <- inputMapping.get("hgt").flatMap(validateHeight)
      hairColor <- inputMapping.get("hcl").flatMap(validateHairColor)
      eyeColor <- inputMapping.get("ecl").flatMap(validateEyeColor)
      passportId <- inputMapping.get("pid").flatMap(validatePassportId)
    } yield {
      Passport(
        birthYear,
        issueYear,
        expirationYear,
        height,
        hairColor,
        eyeColor,
        passportId,
        inputMapping.get("cid")
      )
    }
  }

  private def validateRequiredFields(givenFields: Set[String]): Boolean = {
    RequiredFields.diff(givenFields).size == 0
  }

  private def validateBirthYear(str: String): Option[String] =
    validateYear(str, 1920, 2002)
  private def validateIssueYear(str: String): Option[String] =
    validateYear(str, 2010, 2020)
  private def validateExpirationYear(str: String): Option[String] =
    validateYear(str, 2020, 2030)
  private def validateYear(
      str: String,
      lowerBound: Int,
      upperBound: Int
  ): Option[String] =
    if (lowerBound <= str.toInt && str.toInt <= upperBound) Some(str) else None

  private def validateHeight(str: String): Option[String] = {
    val validHeighPattern = """\A([\d]+)(cm|in)\z""".r("value", "metric")
    validHeighPattern.findFirstMatchIn(str).flatMap { m =>
      val value = m.group(1)
      val metric = m.group(2)
      if (metric == "cm" && 150 <= value.toInt && value.toInt <= 193) Some(str)
      else if (metric == "in" && 59 <= value.toInt && value.toInt <= 76)
        Some(str)
      else None
    }
  }

  private def validateHairColor(str: String): Option[String] = {
    val validHairColorPattern = """\A#[a-z0-9]{6}\z""".r("value", "metric")
    validHairColorPattern.findFirstIn(str)
  }

  private def validateEyeColor(str: String): Option[String] =
    if (ValidEyeColors.contains(str)) Some(str) else None

  private def validatePassportId(str: String): Option[String] = {
    val validPassportIdPattern = """\A[\d]{9}\z""".r
    validPassportIdPattern.findFirstIn(str)
  }
}
