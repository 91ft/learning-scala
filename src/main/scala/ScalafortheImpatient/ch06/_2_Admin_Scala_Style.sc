/*
* 운영자
*/
class Admin(id : Long, name : String) {
  import Admin._

  override def toString() = s"${name}"
  def call() = print(initId)
}

/*
* 컴패니언 오브젝트
*/
object Admin {
  private val initId = 0L
  def apply(name : String) : Admin = new Admin(createUniqId(), name) // apply
  def createUniqId() : Long = 0L // Uniq Id를 리턴함. 임시로 0L
}

val newAdmin = Admin("김수현")
//Admin.initId