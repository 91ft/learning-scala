package ScalafortheImpatient.ch06

/**
 * Created by vies00 on 16. 3. 9..
 */
//object _8_Main3 extends MyApp {
//  println("Hello MyApp!!")
//}


trait MyApp extends DelayedInit {
  var x : Any = null
  override def delayedInit(cons: => Unit) {
    x = cons
  }
  def main(args: Array[String]): Unit = {
    x
  }
}