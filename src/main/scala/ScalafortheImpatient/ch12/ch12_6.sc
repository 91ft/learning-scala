
/*
클로저
 */
def mulOnAtATime(x:Int)=(y:Int) => x*y
mulOnAtATime(5)(6)
val a1 = Array("Hello", "World")
val b1 = Array("hello", "world")
a1.corresponds(b1)(_.equalsIgnoreCase(_))
val a = Array("Hello", "World")
val b = Array(5, 5)
a.corresponds(b)(_.length == _)