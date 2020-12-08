package adventofcode.third

class TreeGrid(
    private val grid: Array[Array[Char]],
    private val width: Int,
    private val height: Int
) {

  type Coordinate = (Int, Int)
  private val StartingCoordinate = (0, 0)

  type RelativeCoordinate = (Int, Int)
  val Right: RelativeCoordinate = (0, 1)
  val Down: RelativeCoordinate = (1, 0)

  private val slope = Slope(width, height)

  def countTreeWhileTraversing(): Int = {
    val traversePatterns = List(Right, Right, Right, Down)

    countTreeHelper(traversePatterns, StartingCoordinate, 0)._2
  }

  def countTreePartTwo(): Long = {
    val multiWaysOfTraverse = List(
      List(Right, Down),
      List.fill(3)(Right) :+ Down,
      List.fill(5)(Right) :+ Down,
      List.fill(7)(Right) :+ Down,
      List(Right, Down, Down)
    )

    val result = multiWaysOfTraverse.map { traversePatterns =>
      countTreeHelper(traversePatterns, StartingCoordinate, 0)
    }.map(_._2.toLong)
    println(result)

    result.reduce(_ * _)
  }

  override def toString(): String = {
    grid
      .map { row =>
        row.mkString("")
      }
      .mkString("\n")
  }

  private def countTreeHelper(
    traversePatterns: List[RelativeCoordinate],
      currentCoordinate: Coordinate,
      currentTreeCount: Int
  ): (Coordinate, Int) = {
    // to account for zero-based index
    if (currentCoordinate._1 + 1 == height)
      return (currentCoordinate, currentTreeCount)
    else {
      val nextCoordinate = slope.traverse(currentCoordinate, traversePatterns)

      if (isTree(nextCoordinate))
        countTreeHelper(traversePatterns, nextCoordinate, currentTreeCount + 1)
      else countTreeHelper(traversePatterns, nextCoordinate, currentTreeCount)
    }
  }

  private def isTree(coordinate: (Int, Int)): Boolean =
    grid(coordinate._1)(coordinate._2) == '#'
}

object TreeGrid {
  def create(input: List[String]): TreeGrid = {
    val height = input.size
    val width = input.head.size
    val grid = input.map(_.toArray).toArray

    println(s"width = $width, height = $height")
    new TreeGrid(grid, width, height)
  }
}
