package ScalafortheImpatient.ch08

/**
  * Created by Harley on 2016. 4. 6..
  */
class Koguryo(name: String, center: String) extends Country(name) {
  override def toString = super.toString + ">> [" + name + "]"
}
