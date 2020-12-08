package adventofcode.fifth

object BoardingPassScanner {

  def highestSeatId(inputs: List[String]): Long = {
    inputs.map(SeatConverter.convert).map(calculateSeatId).max
  }

  def findYourSeat(inputs: List[String]): Long = {
    val allSeatIds = inputs.map(SeatConverter.convert).map(calculateSeatId).sorted
    // (1L, 45L): the first one is the difference between current seat id and previous seat id, the second one is the current seat id
    val gapSeatIds = allSeatIds.scanLeft((0L, 0L)) { case (a, b) => (b - a._2, b) }
    gapSeatIds.filter(_._1 == 2).head._2 - 1
  }

  private def calculateSeatId(rowAndColumnTup: (Int, Int)): Long = rowAndColumnTup match {
    case (row, column) => row * 8L + column
  }
}
