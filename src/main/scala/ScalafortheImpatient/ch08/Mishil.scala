package ScalafortheImpatient.ch08

/**
  * Created by Harley on 2016. 4. 6..
  */
class Mishil(codename: String) extends Person(codename) {
  override val name = "top secret!"
  override val toString = "top secret, too!" //override ref가 아니라 override val인게 특이하군

  override def id: Int = {
    1
  }
}
