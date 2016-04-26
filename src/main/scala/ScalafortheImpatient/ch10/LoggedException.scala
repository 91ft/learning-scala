package ScalafortheImpatient.ch10

/**
  * Created by Harley on 2016. 4. 26..
  */
trait LoggedException extends Exception with Logged {
   def log() { log(getMessage)}
}
