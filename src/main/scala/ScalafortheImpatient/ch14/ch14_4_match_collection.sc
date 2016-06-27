trait Template

class Banner(url : String) extends Template {
  def goUrl() = println(s"링크 = ${url}")
}
class Keyword(kewords : String*) extends Template {
  def showKeywords() = println(s"키워드 = ${kewords.mkString("#", ", #", "")}")
}
class Tab(tabs : String*) extends Template {
  def showTabs() = println(s"탭 = ${tabs.mkString("|", "|", "|")}")
}

/**************************************
  * 패턴 매칭 collection
  *************************************/

def processTemplates(templates : List[Template]) =
  templates match {
    case (b1 : Banner) :: (b2 : Banner) :: tail => println("배너가 앞에 2개 있는 패턴")
    case (b : Banner) :: tail => println("배너가 앞에 있는 패턴")
    case _ => println("일반적인 패턴")
  }

val tab = List(new Tab("첫번째탭", "두번째탭"))
val banner_tab = List(new Banner("http://gift.kakao.com"), new Tab("첫번째탭", "두번째탭"))
val tab_banner = List(new Tab("첫번째탭", "두번째탭"), new Banner("http://gift.kakao.com"))
val banner_banner_tab = List(new Banner("http://gift.kakao.com"), new Banner("http://gift.kakao.com"),Tab("첫번째탭", "두번째탭"))

processTemplates(tab)
processTemplates(banner_tab)
processTemplates(tab_banner)
processTemplates(banner_banner_tab)