package adventofcode.first

object ExpenseReport {

  type Pair2020 = (Int, Int)
  type Triplet2020 = (Int, Int, Int)

  def calculate(numbers: List[Int]): Option[Int] = {
    findPairSummingUpTo2020(numbers).map {
      case (x, y) => x * y
    }
  }

  def calculateTriple(numbers: List[Int]): Option[Int] = {
    findTripletSummingUpTo2020(numbers).map {
      case (x, y, z) => x * y * z
    }
  }

  private def findPairSummingUpTo2020(numbers: List[Int]): Option[Pair2020] = {
    val pairs = for {
      x <- numbers
      y <- numbers
      if x + y == 2020
    } yield (x, y)
    pairs.headOption
  }

  private def findTripletSummingUpTo2020(numbers: List[Int]): Option[Triplet2020] = {
    val triplets = for {
      x <- numbers
      y <- numbers
      z <- numbers
      if x + y + z == 2020
    } yield (x, y, z)
    triplets.headOption
  }
}
