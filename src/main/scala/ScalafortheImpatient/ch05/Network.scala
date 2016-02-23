package ScalafortheImpatient.ch05

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Harley on 2016. 2. 23..
  */
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

object Network extends App {
  val scalaStudy = new Network
  val es6Study = new Network

  val liam = scalaStudy.join("Liam")
  val edina = scalaStudy.join("Edina")

  liam.contacts += edina //OK

  //val cheese = es6Study.join("Cheese")
  //liam.contacts += cheese //불가능. 다른 클래스 임

}
