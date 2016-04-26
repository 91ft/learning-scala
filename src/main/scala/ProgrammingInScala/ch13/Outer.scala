package ProgrammingInScala.ch13

/**
  * Created by Harley on 2016. 4. 24..
  */
class Outer {
  class Inner {
    private def f() { println("f") }
    class InnerMost {
      f()
    }
  }

  //(new Inner).f()
}
