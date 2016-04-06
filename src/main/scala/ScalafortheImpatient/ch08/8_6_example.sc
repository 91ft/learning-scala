import ScalafortheImpatient.ch08.{Liam, Mishil, Onjo, Person}

// 8.6 필드 오버라이드하기 예제

val mishil: Person = new Mishil("Liam")
val liam: Person = new Liam("Liam")
val onju: Person = new Onjo("온조", 3)

mishil.id
mishil.name
mishil.toString

liam.id
liam.name
liam.toString

onju.id
onju.name
onju.toString
