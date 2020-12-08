package adventofcode.fifth

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SeatConverterSpec extends AnyFlatSpec with Matchers {
  "convert" should "returns the actual row and column number" in {
    SeatConverter.convert("FBFBBFFRLR") should equal((44, 5))
    SeatConverter.convert("BFFFBBFRRR") should equal((70, 7))
    SeatConverter.convert("FFFBBBFRRR") should equal((14, 7))
    SeatConverter.convert("BBFFBBFRLL") should equal((102, 4))
    SeatConverter.convert("BBBBBBBRRR") should equal((127, 7))
  }
}
