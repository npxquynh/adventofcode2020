package adventofcode.eighth

sealed abstract class Instruction(argument: Int)
case class NoOperation(argument: Int) extends Instruction(argument)
case class Accumulator(argument: Int) extends Instruction(argument)
case class Jump(argument: Int) extends Instruction(argument)

object Instruction {

  def create(operation: String, argument: Int): Instruction = operation match {
    case "nop" => NoOperation(argument)
    case "acc" => Accumulator(argument)
    case "jmp" => Jump(argument)
  }
}
