package adventofcode.eighth

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BootCodeCorrectorSpec extends AnyFlatSpec with Matchers {
  val input = """nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6""".split("\n").toList

  "execute" should "return the last acc before the program repeat the instruction" in {
    BootCodeCorrector
      .withInputs(input)
      .bruteForceToFixInstructions() should equal(ExecutionResult(true, 8))
  }
}
