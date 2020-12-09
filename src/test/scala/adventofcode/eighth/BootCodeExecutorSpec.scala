package adventofcode.eighth

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BootCodeExecutorSpec extends AnyFlatSpec with Matchers {
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
    BootCodeExecutor.withInputs(input).execute() should equal(
      ExecutionResult(false, 5)
    )
  }

  it should "returns acc for valid instructions as well" in {
    val validInstructions = """nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
nop -4
acc +6""".split("\n").toList
    BootCodeExecutor.withInputs(validInstructions).execute() should equal(
      ExecutionResult(true, 8)
    )
  }
}
