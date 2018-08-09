package flat

import com.adt.demo.test.{BaseConvertion, Binary, Decimal}
import org.scalatest.FlatSpec

class Binary2DecimalSpec extends FlatSpec{
  "base convert utilities " should  "convert 11101010  to decimal 234" in {
      val cc = BaseConvertion.binary2Decimal("11101010").sum
      assert(cc.toInt == 234)
  }

  it should  "convert 11101010 to int is 234" in {
    val cc = BaseConvertion.binary2Decimal("11101010").sum
    assert(cc.toInt == 234)
  }

  it should  "convert 234 to binary string is '11101010'" in {
    val dd = BaseConvertion.decimal2Binary(Decimal("234"))
    assert(dd.number == "11101010")
  }
}
