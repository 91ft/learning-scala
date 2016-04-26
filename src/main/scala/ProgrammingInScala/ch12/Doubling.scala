package ProgrammingInScala.ch12

/**
  * Created by Harley on 2016. 4. 22..
  */
trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}

class MyQueue extends BasicIntQueue with Doubling
