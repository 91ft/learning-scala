package ScalafortheImpatient.ch05

/**
  * Created by Harley on 2016. 2. 23..
  */
class Person6(val name: String = "", val age: Int = 0) {

  println("Person6~")

  def description = name + " is " + age + " years old."
}

object Person6 extends App {
  val p = new Person6("Harley", 20)
  println(p.description)

  val p2 = new Person6()
  println(p2.description)
}