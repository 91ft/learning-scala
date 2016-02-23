package ScalafortheImpatient.ch05

/**
  * Created by Harley on 2016. 2. 17..
  */
class Counter {
  private var value = 0
  def increment() { value += 1 }
  def current() = value
}

object Counter extends App {
  val c = new Counter()
  c.increment()
  c.increment()
  println(c.current())
  println(c.current)
}