import ScalafortheImpatient.ch08._

val baekjae : Baekjae = new Baekjae("백제")
println(baekjae.toString)

val c : AnyRef = baekjae

if (c.isInstanceOf[Baekjae]) {
  val s = c.asInstanceOf[Baekjae] //c는 Baekjae 타입
}

c match {
  case b: Baekjae => println("Booyah~ 백제!")
  case _ => println("Where am I?")
}