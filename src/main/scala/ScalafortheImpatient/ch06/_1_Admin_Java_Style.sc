/*
* 운영자
*/
class Admin {
  private var id : Long = 1L
  private var name : String = ""

  def this(id : Long, name : String) = {
    this()
    this.id = id;
    this.name = name;
  }

  override def toString() = s"${name}"
}

/*
* Factory
*/
class AdminFactory {
  def create(name : String) : Admin = new Admin(createUniqId(), name)
  def createUniqId() : Long = 0L // Uniq Id를 리턴함. 임시로 0L
}

/*
* 사용
*/
val admin = new Admin((new AdminFactory).createUniqId(), "김수현");

/*
* Factory 사용
*/
val adminFactory = new AdminFactory
val newAdmin = adminFactory.create("김수현")

