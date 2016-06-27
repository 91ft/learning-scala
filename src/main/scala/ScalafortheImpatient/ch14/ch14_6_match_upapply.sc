trait Template

class MyUrl(url : String)

class GiftLink(url : String) extends MyUrl(url)
class OutLink(url : String) extends MyUrl(url)
class KakaoSchemLink(url : String) extends MyUrl(url)
class KakaoStorySchemLink(url : String) extends MyUrl(url)

object GiftLink {
  def apply(url : String) : GiftLink = new GiftLink(url)
  def unapply(url : String) = if (url.startsWith("/#/")) Some(url) else None
}

object OutLink {
  def apply(url : String) : OutLink = OutLink(url)
  def unapply(url : String) = if (url.startsWith("http://") || url.startsWith("https://")) Some(url) else None
}

def getUrl(url : String) =
  url match {
    case GiftLink(link) => println(s"내부 url = ${link}") // GiftLink(link)
    case OutLink(link) => println(s"외부 url = ${link}")
  }

getUrl("http://m.daum.net")