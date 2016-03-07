/*
* 운영자
*/
class Admin(id : Long, name : String) {
  override def toString() = s"${name}"
}

/*
* 와치타워로 메세지 전송하는 작업
*/
trait SendWatchTower {
  def doJob(msg : String) : Unit = print(s"보낸 메세지 : ${msg}") // 와치타워로 메세지 전송
}

/*
* 봇 운영자
* object는 클래스와 trait를 상속받을 수 있다.
*/
object BotAdmin extends Admin(0L, "봇 운영자") with SendWatchTower

BotAdmin.doJob("메세지를 보내겠다")