package adventofcode.seventh

import adventofcode.GraphUtils

object BagCounter {
  def countOuterBags(inputs: List[String], givenBagColor: String): Int = {
    val bagRule = BagRule.create(inputs)
    val neighbors = bagRule.outerBagsOf(BagColor(givenBagColor))

    GraphUtils
      .bfs[BagColor](neighbors, bagRule.outerBagsOf _, Nil)
      .distinct
      .size
  }

  def countInnerBags(inputs: List[String], givenBagColor: String): Int = {
    val bagRule = BagRule.create(inputs)
    val innerBagsCount = new InnerBagsCount(bagRule)

    bagRule
      .innerBagsWithQuantityOf(BagColor(givenBagColor))
      .map { case BagColorQuantity(bagColor, quantity) => quantity * innerBagsCount.get(bagColor) }
      .sum
  }
}

private class InnerBagsCount(bagRule: BagRule) {
  private val counts = scala.collection.mutable.Map[BagColor, Int]()

  def get(bagColor: BagColor): Int = counts.get(bagColor) match {
    case Some(count) => count
    case None        => {
      updateCountFor(bagColor)
      get(bagColor)
    }
  }

  private def updateCountFor(bagColor: BagColor): Unit = {
    val count = bagRule.innerBagsWithQuantityOf(bagColor).foldLeft(0) {
      case (quantity, bagColorQuantity) => {
        quantity + bagColorQuantity.quantity * get(bagColorQuantity.bagColor)
      }
    }
    // Update
    counts += ((bagColor, count + 1)) // +1 to account for the bag itself
  }
}
