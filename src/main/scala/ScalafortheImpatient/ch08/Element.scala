package ScalafortheImpatient.ch08

/**
  * Created by Harley on 2016. 4. 5..
  *
  * contents는 구현이 없는 메소드로 Element 클래스의 abstract memeber
  * Element는 abstract class
  */
abstract class Element {
  val id: Int
  var name: String
  def contents: String
}
