/*                     __                                                  *\
**     ________ ___   / /  ___     Coursera progfun2                       **
**    / __/ __// _ | / /  / _ |    2016, Gift Dev Team                     **
**  __\ \/ /__/ __ |/ /__/ __ |    https://www.coursera.org/learn/progfun2 **
** /____/\___/_/ |_/____/_/ | |                                            **
**                          |/                                             **
\*                                                                         */

import progfun2.week1._

///////////////////////////
// Pattern Matching
///////////////////////////

val data = JObj(Map(
  "firstName" -> JStr("John"),
  "lastName" -> JStr("Smith"),
  "address" -> JObj(Map(
    "streetAddress" -> JStr("21 snd St"),
    "state" -> JStr("NY"),
    "postalCode" -> JNum(10021)
  )),
  "phoneNumbers" -> JSeq(List(
      JObj(Map(
      "type" -> JStr("home"), "number" -> JStr("212 555 -1234")
      )),
      JObj(Map(
        "type" -> JStr("fax"), "number" -> JStr("212 555 -1234")
      ))
  ))
))

def show(json: JSON): String = json match {
  case JSeq(elems) =>
    "[" + (elems map show mkString ",") + "]"
  case JObj(bindings) =>
    val assocs = bindings map {
      case (key, value) => "\"" + key + "\":" + show(value)
    }
    "{" + (assocs mkString ", ") + "}"
  case JNum(num) => num.toString
  case JStr(str) => '\"' + str + '\"'
  case JBool(b) => b.toString
  case JNull => "null"
}

// result
show(data)

// excercise - 1
val f: PartialFunction[List[Int], String] = {
  case Nil => "One"
  case x :: y :: rest => "two"
}

f.isDefinedAt(List(1,2,3))
f.apply(List(1,2,3))

// excercise - 2
val g: PartialFunction[List[Int], String] = {
  case Nil => "One"
  case x :: rest =>
    rest match {
      case Nil => "Two"
    }
}

g.isDefinedAt(List(1,2,3)) //true. 함수 패턴 매칭의 가장 상위 case만 본다.
g.apply(List(1,2,3)) //MatchError