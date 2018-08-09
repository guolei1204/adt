package com.adt.demo.test

object BaseConvertion {
  def decimal2Binary(decimal: Decimal) = {
    decimal.number.toInt

  }

  def toBinary(org: BigInt, acc: String) = {
    if (org < 2) {
      org.toString + acc
    }
    else {
      org.mod(2).toString() + acc
    }
  }

  def binary2Decimal(bStr:String) = {
    Binary(bStr).number.reverse.zipWithIndex.map{case (c,i) => c.toString.toInt * Math.pow(2,i)}
  }
}
