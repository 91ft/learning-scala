package ScalafortheImpatient.ch05

/**
  * Created by Harley on 2016. 2. 23..
  */
class Person5 {

  private var name = ""
  private var age = 0

  def this(name: String) { //보조 생성자
    this()
    this.name = name
  }

  def this(name: String, age: Int) { // 다른 보조 생성자
    this(name) //앞서 정의된 보조 생성자 호출
    this.age = age
  }

  def printPerson() {
    val p2s = name + ":" + age
    println(p2s)
  }
}

object Person5 extends App {
  val p1 = new Person5
  p1.printPerson()

  val p2 = new Person5("Harley")
  p2.printPerson()

  val p3 = new Person5("Harley", 20)
  p3.printPerson()

}
