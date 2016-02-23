package ScalafortheImpatient.ch05

/**
  * Created by Harley on 2016. 2. 23..
  */
class Counter2 {
  private var value = 0
  //private[this] var value = 0

  def increment() { value += 1 }
  def current() = value

  def isLess(other: Counter2) = value < other.value //다른 오브젝트의 비공개 필드에 접근 가능함!
}

object Counter2  extends App {
  val c = new Counter2()
  c.increment()
  c.increment()
  println(c.current())
  println(c.current)
}