package ScalafortheImpatient.ch10

/**
  * Created by Harley on 2016. 4. 20..
  */
trait Logged {
  def log(msg: String) {}
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) = { println(msg) }
}

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger extends Logged {
  //val maxLength = 15
  val maxLength: Int //an abstract field
  abstract override def log(msg: String) {
    super.log(
      if(msg.length <= maxLength) msg else msg.substring(0, maxLength-3) + "..."
    )
  }
}

class Account {
  var balance: Double = 0
}

class SavingAccount extends Account with Logged {
  var interest = 0.0
  //val maxLength = 20

  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient founds")
    else balance -= amount
  }
}