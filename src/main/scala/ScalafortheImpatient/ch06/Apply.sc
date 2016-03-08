val func1 = (msg : String) => s"[출력1] $msg"
func1("글을 쓴다")
func1.apply("성공!")


val func2 = new PartialFunction[String, String] {

  override def apply(msg : String): String = s"[출력2] $msg"
  override def isDefinedAt(x: String): Boolean = x != null
}
func2("글을 쓴다")
func2.apply("또 성공!")
