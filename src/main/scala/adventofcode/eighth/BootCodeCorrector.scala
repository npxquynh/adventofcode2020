package adventofcode.eighth

class BootCodeCorrector(
    private val originalInstructions: IndexedSeq[Instruction]
) {

  def bruteForceToFixInstructions(): ExecutionResult = {
    val iter1 = changeNoOperationToJump()
    val iter2 = changeJumpOperationToNoOperation()

    val executionResult = testExecutingInstructionsUntilProgramIsFinished(
      iter1 ++ iter2
    )

    if (executionResult.programFinished) executionResult
    else
      throw new RuntimeException(
        "Cannot change any instruction to make program finish"
      )
  }

  private def changeNoOperationToJump(): Iterator[IndexedSeq[Instruction]] = {
    val noOperationsWithIndex = originalInstructions.iterator.zipWithIndex.filter {
      case (NoOperation(_), _) => true
      case _                   => false
    }
    noOperationsWithIndex.map { case (NoOperation(argument), index) =>
      originalInstructions.updated(index, Jump(argument))
    }
  }

  private def changeJumpOperationToNoOperation()
      : Iterator[IndexedSeq[Instruction]] = {
    val jumpOperationsWithIndex = originalInstructions.iterator.zipWithIndex.filter {
      case (Jump(_), _) => true
      case _            => false
    }
    jumpOperationsWithIndex.map { case (Jump(argument), index) =>
      originalInstructions.updated(index, NoOperation(argument))
    }
  }

  private def testExecutingInstructionsUntilProgramIsFinished(
      testInstructionsIter: Iterator[IndexedSeq[Instruction]]
  ): ExecutionResult = {
    var executionResult = ExecutionResult(programFinished = false, acc = 0)

    // TODO: maybe create a type to short-circuit when boolean is false
    while (!executionResult.programFinished && testInstructionsIter.hasNext) {
      executionResult = new BootCodeExecutor(testInstructionsIter.next).execute()
    }

    executionResult
  }
}

object BootCodeCorrector {
  def withInputs(inputs: List[String]): BootCodeCorrector =
    new BootCodeCorrector(BootCodeExecutor.parse(inputs))
}
