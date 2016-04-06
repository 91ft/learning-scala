import ScalafortheImpatient.ch08.Person

val alien = new Person("ET") {
  override def id: Int = 9

  def greeting = "Hi! My name is ET."
}

def meet(p: Person{def greeting: String}): Unit = {
  println(s"id = ${p.id}")
  println(s"name = ${p.name}")
  println(s"toString = ${p.toString}")
  println(s"greeting = ${p.greeting}") //greeting 구조타입이 추가되었음
}

meet(alien)