package adventofcode.fourth

case class Passport(
  birthYear: String,
  issueYear: String,
  expirationYear: String,
  height: String,
  hairColor: String,
  eyeColor: String,
  id: String,
  countryId: Option[String]
)
