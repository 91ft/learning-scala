case class A(a: Int)
val b = A(1)
val c = A(1)

object B {
  val name: String = "a"
}

b == c
b equals c
b eq c

val bb = B
val bb2 = B

bb == bb2
bb equals bb2
bb eq bb2