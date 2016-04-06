package ScalafortheImpatient.ch08

/**
  * Created by Harley on 2016. 4. 6..
  */
class Liam(name: String) extends Person(name) {
  override def toString = super.toString + ">> [" + name + "]"

  override def id: Int = {
    2
  }
}
