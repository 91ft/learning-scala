package ScalafortheImpatient.ch05

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Harley on 2016. 2. 23..
  */
class Network3 {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network3#Member] //Network3의 Member를 의미하는 타입 프로젝션 사용 (18장에서 배울 예정 임)
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}
object Network3 extends App {

  val scalaStudy = new Network3
  val es6Study = new Network3

  val liam = scalaStudy.join("Liam")
  val edina = scalaStudy.join("Edina")

  liam.contacts += edina //OK

  val cheese = es6Study.join("Cheese")
  liam.contacts += cheese //OK

}