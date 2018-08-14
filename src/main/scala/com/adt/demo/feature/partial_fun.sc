val squareRoot:PartialFunction[Int,Double] = {
  case a if a > 0 => Math.sqrt(a.toDouble)
}

List(1,9,81,-64).collect(squareRoot)