package ScalafortheImpatient.ch14

/**
 * Created by karellen on 2016. 6. 27..
 */

trait Template

case class Banner(url : String) extends Template {
  def isOutLinkUrl() = url.startsWith("http://")
  def goOutLinkUrl() = println(s"아웃링크 = ${url}")
  def goUrl() = println(s"링크 = ${url}")
}
case class Keyword(kewords : String*) extends Template {
  def showKeywords() = println(s"키워드 = ${kewords.mkString("#", ", #", "")}")
}
case class Tab(tabs : String*) extends Template {
  def showTabs() = println(s"탭 = ${tabs.mkString("|", "|", "|")}")
}

object MyMatch extends App {

  def processTemplate(template : Template) =
    template match {
      case b : Banner if b.isOutLinkUrl => b.goOutLinkUrl()
      case b : Banner => b.goUrl()
      case k : Keyword => k.showKeywords()
      case t : Tab => t.showTabs()
      case a => print("not match : " + a)
    }

  var banner = Banner("http://gift.kakao.com")
  var keyword = Keyword("첫번째키워드", "두번째키워드")
  var tab = Tab("첫번째탭", "두번째탭")
  processTemplate(banner)
  processTemplate(keyword)
  processTemplate(tab)
}
