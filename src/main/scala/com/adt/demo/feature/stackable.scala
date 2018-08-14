package com.adt.demo.feature

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int

  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  val buffer = new ArrayBuffer[Int]()

  override def get(): Int = buffer.remove(0)

  override def put(x: Int): Unit = buffer += x

  def  size() = buffer.size
}

trait DoubleIntQueue extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(2 * x)
}

trait IncrementIntQueue extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(1 + x)
}

trait FilterIntQueue extends IntQueue {
  abstract override def put(x: Int): Unit = if (x > 0) {
    super.put(x)
  }
}


object stackable {
  def main(args: Array[String]): Unit = {
    val queue = new BasicIntQueue with DoubleIntQueue with IncrementIntQueue with FilterIntQueue
    queue.put(-1)
    queue.put(-2)
    queue.put(1)
    queue.put(9)
    while(queue.size()>0){
      println(queue.get())
    }
  }
}
