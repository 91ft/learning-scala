package ProgrammingInScala.ch12

/**
  * Created by Harley on 2016. 4. 22..
  */
trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = {
    if (x >= 0) super.put(x)
  }
}
