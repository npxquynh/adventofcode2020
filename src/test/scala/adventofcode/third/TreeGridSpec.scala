package adventofcode.third

import org.scalatest.matchers.should.Matchers._
import org.scalatest.flatspec.AnyFlatSpec
import scala.io.Source

class TreeGridSpec extends AnyFlatSpec {
  "toString" should "display the grid" in {
    val input = Source.fromResource("./day03.txt").getLines().toList
    val treeGrid = TreeGrid.create(input)

    treeGrid.toString() should equal(input.mkString("\n"))
  }

  "countTreeWhileTraversing" should "returns the number of trees encountered" in {
    val input = Source.fromResource("./day03.txt").getLines().toList
    val treeGrid = TreeGrid.create(input)

    treeGrid.countTreeWhileTraversing() should equal(7)
  }

  "countTreePartTwo" should "returns the multiplication of all tree counts" in {
    val input = Source.fromResource("./day03.txt").getLines().toList
    val treeGrid = TreeGrid.create(input)

    treeGrid.countTreePartTwo should equal(336)
  }

}
