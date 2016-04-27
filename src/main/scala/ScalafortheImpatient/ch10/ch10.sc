import ScalafortheImpatient.ch10._

//10.4
val acct: SavingAccount = new SavingAccount
acct.withdraw(100)
//
//val acct2 = new SavingAccount with ConsoleLogger
//acct2.withdraw(200)

// 10.5
//val acct3 = new SavingAccount with ConsoleLogger
//                              with TimestampLogger
//                              with ShortLogger
//acct3.withdraw(300)
//
//val acct4 = new SavingAccount with ConsoleLogger
//  with ShortLogger
//  with TimestampLogger
//acct4.withdraw(300)

// 10.6
//val acct6 = new SavingAccount106
//acct6.withdraw(300)

// 10.7
//val acc7 = new SavingsAccount107
//acc7.withdraw(300)

//10.9
//val acct9 = new SavingAccount with ConsoleLogger with ShortLogger {
//  val maxLength = 10
//}
//acct9.withdraw(300)