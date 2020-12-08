package adventofcode.third

case class Slope(private val width: Int, private val height: Int) {

  type Coordinate = (Int, Int)
  type RelativeCoordinate = (Int, Int)
  val Right: RelativeCoordinate = (0, 1)
  val Down: RelativeCoordinate = (1, 0)

  def traverse(currentCoordinate: Coordinate, traversePatterns: List[RelativeCoordinate]): Coordinate = {
    traversePatterns.foldLeft(currentCoordinate)(findCoordinate)
  }

  private def findCoordinate(
      currentCoordinate: Coordinate,
      relativeCoordinate: RelativeCoordinate
  ): Coordinate = {
    // We don't have to pay attention to negative case
    val x = (currentCoordinate._1 + relativeCoordinate._1) % (height)
    val y = (currentCoordinate._2 + relativeCoordinate._2) % (width)
    (x, y)
  }
}
