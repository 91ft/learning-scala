trait Template

class Banner(url : String) extends Template {
  def isOutLinkUrl() = url.startsWith("http://")
  def goOutLinkUrl() = println(s"아웃링크 = ${url}")
  def goUrl() = println(s"링크 = ${url}")
}
class Keyword(kewords : String*) extends Template {
  def showKeywords() = println(s"키워드 = ${kewords.mkString("#", ", #", "")}")
}
class Tab(tabs : String*) extends Template {
  def showTabs() = println(s"탭 = ${tabs.mkString("|", "|", "|")}")
}

/**************************************
  * 패턴 매칭 가드
  *************************************/

def processTemplate(template : Template) =
  template match {
    case b : Banner if b.isOutLinkUrl => b.goOutLinkUrl()
    case b : Banner => b.goUrl()
    case k : Keyword => k.showKeywords()
    case t : Tab => t.showTabs()
    case a => print("not match : " + a)
  }

var link = new Banner("http://story.kakao.com/")
var outlink = new Banner("/#/home")
processTemplate(link)
processTemplate(outlink)