package ScalafortheImpatient.ch10

/**
  * Created by Harley on 2016. 4. 26..
  */
trait A {
  def test: String
}

trait B extends A {
  abstract override def test = {
    s"B${super.test}"
  }
}

// Compile Error!!
//class C extends A with B {
//  override def test = { "C" }
//}

// Solution 1.
//class C extends A { override def test = { "C" } }
//
//object ABCTest extends App {
//  val c = new C with B
//  println(c.test)
//}

// Solution 2.
//class C extends A {
//  override def test = { "C" }
//}
//class D extends C with B
//
//object ABCTest extends App {
//  val d = new D
//  println(d.test)
//}