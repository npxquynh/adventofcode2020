package adventofcode.fifth

object SeatConverter {

  def convert(seat: String): (Int, Int) = {
    val (row, column) = seat.splitAt(7)
    val rowBinary = row.replace('F', '0').replace('B', '1')
    val columnBinary = column.replace('L', '0').replace('R', '1')

    (binaryToDecimal(rowBinary), binaryToDecimal(columnBinary))
  }

  private def binaryToDecimal(str: String): Int =
    Integer.parseInt(str, 2)
}
