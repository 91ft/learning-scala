package ScalafortheImpatient.ch10

import java.io.PrintStream

/**
  * Created by Harley on 2016. 4. 26..
  */
trait Logger {
  def log2(msg: String) {}
}
//
//trait FileLogger extends Logger {
//  val filename: String
//  val out = new PrintStream(filename)
//  def log(msg: String) { out.println(msg); out.flush() }
//}
//
//object FileLoggerApp extends App {
//  val acct = new SavingAccount with FileLogger {
//    val filename = "myapp.log"
//  }
//}