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

val bannerFunc = new PartialFunction[Template, Unit] {
  override def isDefinedAt(b: Template): Boolean = b.isInstanceOf[Banner]
  override def apply(b: Template): Unit = b.asInstanceOf[Banner].goUrl()
}

val keywordFunc = new PartialFunction[Template, Unit] {
  override def isDefinedAt(b: Template): Boolean = b.isInstanceOf[Keyword]
  override def apply(b: Template): Unit = b.asInstanceOf[Keyword].showKeywords()
}

val tabFunc = new PartialFunction[Template, Unit] {
  override def isDefinedAt(b: Template): Boolean = b.isInstanceOf[Tab]
  override def apply(b: Template): Unit = b.asInstanceOf[Tab].showTabs()
}

def processTemplate(template : Template) =
  if (bannerFunc.isDefinedAt(template)) bannerFunc(template)
  else if (keywordFunc.isDefinedAt(template)) keywordFunc(template)
  else if (tabFunc.isDefinedAt(template)) tabFunc(template)
  else print("not match : " + template)


var banner = new Banner("http://gift.kakao.com")
var keyword = new Keyword("첫번째키워드", "두번째키워드")
var tab = new Tab("첫번째탭", "두번째탭")

bannerFunc.isDefinedAt(banner)
bannerFunc.isDefinedAt(keyword)

processTemplate(banner)
processTemplate(keyword)
processTemplate(tab)