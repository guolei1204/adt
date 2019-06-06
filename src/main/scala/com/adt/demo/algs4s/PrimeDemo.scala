package com.adt.demo.algs4s

object PrimeDemo {
  def main(args: Array[String]): Unit = {
    println(primes.take(15).toList)

    println(dec2Bin(324))
  }

  val primes: Stream[Int] = 2 #:: Stream.from(3).filter { x =>
    val sqrtOfPrimes = primes.takeWhile { y =>
      y < math.sqrt(x)
    }
    !sqrtOfPrimes.exists(y => x % y == 0)
  }

  def dec2Bin(x: Int): String = {
    val seqOfDivByTwo = Iterator.iterate(x)(x => x / 2)
    val binList = seqOfDivByTwo.takeWhile(_ > 0).map(_ % 2)
    binList.mkString.reverse
  }
}
