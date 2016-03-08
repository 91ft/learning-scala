package ScalafortheImpatient.ch06


/*
* 운영자
*/
class Admin(id : Long, name : String) {
  override def toString() = s"${name}"
}

/*
* 컴패니언 오브젝트
*/
object Admin {
  def apply(name : String) : Admin = new Admin(createUniqId(), name) // apply
  def createUniqId() : Long = 0L // Uniq Id를 리턴함. 임시로 0L
}


object Main extends App {
  val newAdmin = Admin("김수현")
}
