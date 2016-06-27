class Template(val templateType : String)

class Banner(url : String) extends Template("BANNER") {
  def goUrl() = println(s"링크 = ${url}")
}
class Keyword(kewords : String*) extends Template("KEYWORD") {
  def showKeywords() = println(s"키워드 = ${kewords.mkString("#", ", #", "")}")
}
class Tab(tabs : String*) extends Template("TAB") {
  def showTabs() = println(s"탭 = ${tabs.mkString("|", "|", "|")}")
}


/**************************************
  * 문자열 패턴 매칭
  *************************************/

def processTemplate(template : Template) =
  template.templateType match {
    case "BANNER" => template.asInstanceOf[Banner].goUrl()
    case "KEYWORD" => template.asInstanceOf[Keyword].showKeywords()
    case "TAB" => template.asInstanceOf[Tab].showTabs()
    case _ => print("not match!")
  }


var banner = new Banner("http://gift.kakao.com")
var tab = new Tab("첫번째탭", "두번째탭")

processTemplate(banner)
processTemplate(tab)
