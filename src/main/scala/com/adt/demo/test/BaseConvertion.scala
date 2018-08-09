package com.adt.demo.test

import scala.annotation.tailrec

object BaseConvertion {

  def decimal2Binary(decimal: Decimal) = {
    Binary(toBinary(BigInt.apply(decimal.number.toInt),""))
  }

  @tailrec
  def toBinary(org: BigInt, acc: String) :String = {
    if (org < 2) {
      org.toString + acc
    }
    else {
      toBinary(org / 2 , org.mod(2).toString() + acc)
    }
  }

  def binary2Decimal(bStr:String) = {
    Binary(bStr).number.reverse.zipWithIndex.map{case (c,i) => c.toString.toInt * Math.pow(2,i)}
  }
}
