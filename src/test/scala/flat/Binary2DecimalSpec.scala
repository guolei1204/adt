package flat

import com.adt.demo.test.{BaseConvertion, Binary}
import org.scalatest.FlatSpec

class Binary2DecimalSpec extends FlatSpec{
  "base convert utilities " should  "convert 11101010  to decimal 234" in {
      val cc = BaseConvertion.binary2Decimal("11101010").sum
      assert(cc.toInt == 234)
  }
}
