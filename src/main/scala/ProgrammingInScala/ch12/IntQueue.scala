package ProgrammingInScala.ch12

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Harley on 2016. 4. 22..
  */
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}