package adventofcode.seventh

import BagColor._

case class BagColorQuantity(bagColor: BagColor, quantity: Int)

case class BagRule(
    outerToInnerBagMapping: Map[BagColor, List[BagColorQuantity]]
) {

  lazy val innerToOuterBagMapping: Map[BagColor, List[BagColor]] = {
    outerToInnerBagMapping.toList
      .flatMap { case (outsideBagColor, bagColorQuantities) =>
        bagColorQuantities.map { insideBag =>
          (insideBag.bagColor, outsideBagColor)
        }
      }
      .groupBy(_._1)
      .map { case (insideBag, result) =>
        (insideBag, result.map(_._2))
      }
  }

  def innerBagsOf(outerBagColor: BagColor): List[BagColor] =
    outerToInnerBagMapping.getOrElse(outerBagColor, Nil).map(_.bagColor)

  def innerBagsWithQuantityOf(outerBagColor: BagColor): List[BagColorQuantity] =
    outerToInnerBagMapping.getOrElse(outerBagColor, Nil)

  def outerBagsOf(innerBagColor: BagColor): List[BagColor] =
    innerToOuterBagMapping.getOrElse(innerBagColor, Nil)
}
object BagRule {

  def create(inputs: List[String]): BagRule = {
    val mapping = inputs.map(parseOneLine).toMap
    new BagRule(mapping)
  }

  private def parseOneLine(line: String): (BagColor, List[BagColorQuantity]) = {
    val pattern = """([\w\s]+) bag[s]{0,1} contain (.*)""".r

    pattern.findAllMatchIn(line).map { m1 =>
        val outsideBag = BagColor(m1.group(1))
        val insideBagsString = m1.group(2)

        val insideBagPattern = """([\d]+) ([\w\s]+) bag[s]{0,1}""".r
        val insideBags = insideBagPattern
          .findAllMatchIn(insideBagsString)
          .map { m2 =>
            BagColorQuantity(BagColor(m2.group(2)), m2.group(1).toInt)
          }
          .toList

        (outsideBag, insideBags)
    }.toList.head
  }
}
