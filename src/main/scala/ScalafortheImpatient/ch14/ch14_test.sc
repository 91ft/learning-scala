get("1")
get(1)
def get(one : Any) = one match {
  case _ : Int => "숫자"
  case _ : String => "문자"
}


class Email(val id : String, val domain : String)
object Email {
  def unapply(e : Email) = Some(e.id, e.domain)
}
val mail = new Email("gift", "daum.net")

mail match {
  case Email(i, d) => s"주소는 ${i}@${d}입니다."
}