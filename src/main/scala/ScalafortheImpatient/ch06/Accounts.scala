package ScalafortheImpatient.ch06

/**
  * Created by Harley on 2016. 2. 23..
  */
class Accounts {
  val id = Accounts.newUniqueNumber() // 정적 메소드
  private var balance = 0.0
  def deposit(amount: Double) { balance += amount } //인스턴스 메소드
  def getBalance = balance
}

object Accounts { //컴패니언 오브젝트. Accounts 클래스와 이름이 같다. 같은 소스파일에 존재해야 서로의 비공개 기능에 접근 가능하다.
  private var lastNumber = 0
  def newUniqueNumber() = {lastNumber += 1; lastNumber}
}

//object Main extends App {
////  println(Accounts.newUniqueNumber())
////  println(Accounts.newUniqueNumber())
////  println(Accounts.newUniqueNumber())
////  println(Accounts.newUniqueNumber())
//
//  val acc = new Accounts()
//   acc.deposit(1.0)
//   acc.deposit(1.0)
//   acc.deposit(1.0)
//   acc.deposit(1.0)
//   acc.deposit(1.0)
//  println(acc.getBalance)
//}

