package ScalafortheImpatient.ch10

/**
  * Created by Harley on 2016. 4. 26..
  */
trait Logger107 {
  def log(msg: String)
  def info(msg: String) { log("INFO:"+msg) }
  def warn(msg: String) { log("WARN:"+msg) }
  def server(msg: String) { log("SERVER:"+msg) }
}

class SavingsAccount107 extends Account with Logger107 {
  override def log(msg: String) { println(msg) }

  def withdraw(amount: Double): Unit = {
    if (amount > balance) server("Insufficient founds")
    else balance -= amount
  }

}
