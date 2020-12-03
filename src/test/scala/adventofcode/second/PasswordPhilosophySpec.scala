package adventofcode.second

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class PasswordPhilosophySpec extends AnyFlatSpec {
  ".countValidPasswords" should "returns correct number" in {
    val inputs = List(
      "1-3 a: abcde",
      "1-3 b: cdefg",
      "2-9 c: ccccccccc"
    )
    PasswordPhilosophy.countValidPassswords(inputs) should be(2)
  }

  ".countValidPasswordsPart2" should "returns correct number" in {
    val inputs = List(
      "1-3 a: abcde",
      "1-3 b: cdefg",
      "2-9 c: ccccccccc"
    )
    PasswordPhilosophy.countValidPassswordsPart2(inputs) should be(1)
  }
}
