trait Template

case class Banner(protocol : String , host : String) extends Template {
  def goUrl() = println(s"링크 = ${protocol}://${host}")
}
case class Keyword(keword1 : String, keword2 : String) extends Template {
  def showKeywords() = println(s"키워드 = ${keword1}, ${keword2}")
}
case class Tab(tab1 : String, tab2 : String) extends Template {
  def showTabs() = println(s"탭 = ${tab1}, ${tab2}")
}

/**************************************
  * 타입 패턴 매칭
  *************************************/

def processTemplate(template : Template) =
  template match {
    case Banner(p, h) => println(s"뽑아냄..! ${h}")
    case Keyword(k1, k2) => println(s"뽑아냄..! ${k2}")
    case Tab(t1, t2) => println(s"뽑아냄..! ${t2}")
    case a => print("not match : " + a)
  }
var banner = Banner("http", "gift.kakao.com")
var keyword = Keyword("첫번째키워드", "두번째키워드")
var tab = Tab("첫번째탭", "두번째탭")
processTemplate(banner)
processTemplate(keyword)
processTemplate(tab)