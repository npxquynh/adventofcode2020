package adventofcode.seventh

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

import adventofcode.seventh.BagColor._

class BagRuleSpec extends AnyFlatSpec {

  val input =
    """"light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags."""

  "create" should "creates BagRule instance from text input" in {
    val bagRule = BagRule.create(input.split("\n").toList)
    val expectedOuterToInnerBagMapping = Map(
      BagColor("muted yellow") -> List(
        BagColorQuantity(BagColor("shiny gold"), 2),
        BagColorQuantity(BagColor("faded blue"), 9)
      ),
      BagColor("faded blue") -> List(),
      BagColor("shiny gold") -> List(
        BagColorQuantity(BagColor("dark olive"), 1),
        BagColorQuantity(BagColor("vibrant plum"), 2)
      ),
      BagColor("dark orange") -> List(
        BagColorQuantity(BagColor("bright white"), 3),
        BagColorQuantity(BagColor("muted yellow"), 4)
      ),
      BagColor("bright white") -> List(
        BagColorQuantity(BagColor("shiny gold"), 1)
      ),
      BagColor("vibrant plum") -> List(
        BagColorQuantity(BagColor("faded blue"), 5),
        BagColorQuantity(BagColor("dotted black"), 6)
      ),
      BagColor("dotted black") -> List(),
      BagColor("dark olive") -> List(
        BagColorQuantity(BagColor("faded blue"), 3),
        BagColorQuantity(BagColor("dotted black"), 4)
      ),
      BagColor("light red") -> List(
        BagColorQuantity(BagColor("bright white"), 1),
        BagColorQuantity(BagColor("muted yellow"), 2)
      )
    )
    bagRule.outerToInnerBagMapping should equal(expectedOuterToInnerBagMapping)
  }

  it should "creates a reversed mapping from inner bag to outer bag" in {
    val bagRule = BagRule.create(input.split("\n").toList)
    val expectedInnerToOuterBagMapping = Map(
      BagColor("muted yellow") -> List(
        BagColor("dark orange"),
        BagColor("light red")
      ),
      BagColor("faded blue") -> List(
        BagColor("muted yellow"),
        BagColor("vibrant plum"),
        BagColor("dark olive")
      ),
      BagColor("shiny gold") -> List(
        BagColor("muted yellow"),
        BagColor("bright white")
      ),
      BagColor("dark olive") -> List(BagColor("shiny gold")),
      BagColor("bright white") -> List(
        BagColor("dark orange"),
        BagColor("light red")
      ),
      BagColor("vibrant plum") -> List(BagColor("shiny gold")),
      BagColor("dotted black") -> List(
        BagColor("vibrant plum"),
        BagColor("dark olive")
      )
    )
    bagRule.innerToOuterBagMapping should equal(expectedInnerToOuterBagMapping)
  }
}
