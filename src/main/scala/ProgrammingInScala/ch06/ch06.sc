import ProgrammingInScala.ch06.Rational

//val oneHalf = new Rational(1, 2)
//val twoThirds = new Rational(2, 3)
//val result = oneHalf add twoThirds
//oneHalf.numer
//oneHalf.denom
//
//val five = new Rational(3)

//private def gcd(a: Int, b: Int): Int =
//  if (b == 0) a else gcd(b, a % b)
//
//gcd(2, 10)
//gcd(3, 7)
//

val r1 = new Rational(66, 42)

val x = new Rational(1, 2)
val y = new Rational(2, 3)

x + y
x * y
x.+(y)

val a = x + x * y
val b = (x + x) * y
val c = x + (x * y)

x + 2
x * x
x * 2
//2 * x //Int 2에는 Rational type을 *하는 method가 없으므로 오류발생

implicit def intToRational(x: Int) = new Rational(x)
//int를 Rational로 보게 콩깍지를 씌웠다.
3 * x
