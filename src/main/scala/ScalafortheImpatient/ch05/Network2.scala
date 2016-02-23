package ScalafortheImpatient.ch05

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Harley on 2016. 2. 23..
  */
class Network2 {

  private val members = new ArrayBuffer[Network2.Member]

  def join(name: String) = {
    val m = new Network2.Member(name)
    members += m
    m
  }
}


object Network2 extends App {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
  }

  val scalaStudy = new Network2
  val es6Study = new Network2

  val liam = scalaStudy.join("Liam")
  val edina = scalaStudy.join("Edina")

  liam.contacts += edina //OK

  val cheese = es6Study.join("Cheese")
  liam.contacts += cheese //OK

}