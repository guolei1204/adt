package com.adt.demo.test

object BaseConvertion {
  def binary2Decimal(bStr:String) = {
    Binary(bStr).number.reverse.zipWithIndex.map{case (c,i) => c.toString.toInt * Math.pow(2,i)}
  }
}
