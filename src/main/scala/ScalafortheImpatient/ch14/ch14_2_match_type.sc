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
  * 타입 패턴 매칭
  *************************************/

def processTemplate(template : Template) =
  template match {
    case b : Banner => b.goUrl()
    case k : Keyword => k.showKeywords()
    case t : Tab => t.showTabs()
    case a => print("not match : " + a)
  }
var banner = new Banner("http://gift.kakao.com")
var keyword = new Keyword("첫번째키워드", "두번째키워드")
var tab = new Tab("첫번째탭", "두번째탭")
processTemplate(banner)
processTemplate(keyword)
processTemplate(tab)