package ProgrammingInScala.ch12

/**
  * Created by Harley on 2016. 4. 22..
  */
class Rational (n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)

  val numer: Int = n / g

  val denom: Int = d / g

  def this(n: Int) = this(n, 1) //보조생성자 (auxiliary constructor)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString = numer + "/" + denom

  override def compare(that: Rational) =
    (this.numer * that.denom) - (that.numer * this.denom)
}
