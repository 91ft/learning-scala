import ProgrammingInScala.ch10.{ArrayElement, Element}

val ae1: Array[String] = Array("Harley", "Woden")
val ae2: Array[String] = Array("R3", "KR", "RR")
val element1 = new ArrayElement(ae1)
val element2 = new ArrayElement(ae2)

element1.above(element2).toString
element1.beside(element2).toString

val e1 = Element.elem("Good morning~!")
val e2 = Element.elem("Good afternoon~!")

e1.above(e2)
e1.beside(e2)
