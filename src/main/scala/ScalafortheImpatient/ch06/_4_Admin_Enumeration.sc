// type AdminType = Value // AdminType == AdminType.Value
object AdminType extends Enumeration {
  val System, CS_Manager, Reporter = Value
}

/*
* 운영자
*/
class Admin(adminType : AdminType.Value, id : Long, name : String) {
  override def toString() = s"관리자 타입 : ${adminType}, 이름 : ${name}"
}

/*
* 컴패니언 오브젝트
*/
object Admin {
  def apply(adminType : AdminType.Value, name : String) : Admin = new Admin(adminType, createUniqId(), name) // apply
  def createUniqId() : Long = 0L // Uniq Id를 리턴함. 임시로 0L
}

AdminType.values
Admin(AdminType.Reporter, "김수현")

/*
* Enumeration
*/
AdminType.withName("System")