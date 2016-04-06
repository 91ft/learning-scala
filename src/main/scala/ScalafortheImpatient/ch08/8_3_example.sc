import ScalafortheImpatient.ch08._

val baekjae : Baekjae = new Baekjae("백제")

val c : AnyRef = baekjae
if (c.isInstanceOf[Baekjae]) {
  val s: Baekjae = c.asInstanceOf[Baekjae] //c는 Baekjae 타입
  println(s"Result => ${s.toString}")
} else {
  println("Result => Where am I?")
}

c match {
  case b: Baekjae => println("Booyah~ 백제!")
  case _ => println("Where am I?")
}

