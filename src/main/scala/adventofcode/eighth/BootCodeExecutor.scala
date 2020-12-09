package adventofcode.eighth

class BootCodeExecutor(private val instructions: IndexedSeq[Instruction]) {
  private var acc = 0
  private var instructionIndex = 0
  private var visitedInstructionIndices = scala.collection.mutable.Set[Int]()

  def executeReturningAcc(): Int =
    execute().acc

  def execute(): ExecutionResult = {
    while (
      !visitedInstructionIndices.contains(
        instructionIndex
      ) && hasMoreInstructionsToExecute()
    ) {
      visitedInstructionIndices += (instructionIndex)
      executeOneInstruction()
    }

    ExecutionResult(!hasMoreInstructionsToExecute(), acc)
  }

  def hasMoreInstructionsToExecute(): Boolean =
    instructionIndex < instructions.size

  private def executeOneInstruction() = {
    val instruction = instructions.apply(instructionIndex)

    instruction match {
      case NoOperation(_) => instructionIndex = instructionIndex + 1
      case Accumulator(argument) => {
        instructionIndex = instructionIndex + 1
        acc = acc + argument
      }
      case Jump(argument) => {
        instructionIndex = instructionIndex + argument
      }
      case i => throw new RuntimeException(s"Unexpected instruction: $i")
    }
  }
}

object BootCodeExecutor {
  def withInputs(inputs: List[String]): BootCodeExecutor =
    new BootCodeExecutor(parse(inputs))

  // TODO: this function is also used in BootCodeCorrector
  def parse(inputs: List[String]): IndexedSeq[Instruction] = inputs.map {
    input =>
      val x = input.split(" ")
      Instruction.create(x(0), x(1).toInt)
  }.toIndexedSeq
}
