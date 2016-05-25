package ScalafortheImpatient.ch10

trait Logged106 {
  def log(msg: String) //이 메소드는 추상이다
  //def log(msg: String) {} //TODO. 지워주세요~
}

trait TimestampLogger106 extends Logged106 {
   abstract override def log(msg: String) { //추상 메소드를 오버라이드 한다
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger106 extends Logged106 {
  val maxLength = 15
   abstract override def log(msg: String) { //추상 메소드를 오버라이드 한다
    super.log(
      if(msg.length<=maxLength) msg else msg.substring(0, maxLength-3) + "..."
    )
  }
}


class Account106 extends Logged106{
  override def log(msg: String) { println("@@"+msg) }

  var balance: Double = 0
}


class SavingAccount106 extends Account106 with TimestampLogger106 with ShortLogger106 {

  var interest = 0.0
  //val maxLength = 20

  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient founds")
    else balance -= amount
  }
}

