# Chapter 14. 패턴 매칭과 케이스 클래스

> ### 주요 내용
> * 스칼라에는 자바의 switch 문과 비슷하지만, 더 강력한 match - case 가 있다.
> * 패턴 매칭과 동작하는데 최적화된 케이스 클래스가 있다.

## match - case

자바의 switch - case
```
String result = null;
switch (num) {
    case 1 : result = "one"; break;
    case 2 : result = "two"; break;
    default : result = "other";
}
```
스칼라의 match
```
val result = num match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other" // 이게 없다면 MatchError 발생
}
```
##### 차이점
- switch가 match로 바뀜.
- break가 사라짐.
- : 가 => 로 변경됨.
- default 대신 _.
- match - case가 결과를 반환.

> 헛갈려서 match (num) { case 1 : ... 엉망진창이었음.
> 스칼라 이해하는데 도움이 될 것 같으니 하나씩 살펴보아요.

##### switch가 match로 바뀜.
- switch는 match 라는 용어가 더 적절하며, 개념을 잘 설명해준다.
- match(num)보다 num match 가 자연어에 더 가깝다.
```
object I {
    def like(name: String) = println(s"사랑해요! ${name}")
}

I.like("김수현")
I like "김수현"
```

##### break가 사라짐
```
String result = null;
switch (num) {
    case 1 : result = "one"; break;
    case 2 : result = "two";
    default : result = "other";
}
// num = 2 인 경우 결과값은?
```
- fall-through 문제가 사라짐
- 맞는 경우가 없다면 MatchError가 발생

##### : 가 => 로 변경됨
- :, ->, => 다 헛갈리지만... 잘 생각해보면 함수 선언모양과 비슷하다.
- case 한줄 한줄이 다 함수이다.
```
val result = num match {
    case n : String => "string"
    ...
}
// 함수선언 : (name : String) => s"${name}님"
```

##### default 대신 _.
_는 default를 대체하는 것이 아니다.
```
val result = num match {
    case 1 => "one"
    case 2 => "two"
    case a : Int  => "other" // case _ : Int => "other" // case _ => "other"
}
```

##### match - case가 결과를 반환.
```
// 자바
String result = null;
switch (num) { ... result = ... }

// 스칼라의
val result = num match { ... }
```
- match는 표현식이지 문이 아니다. (not statement, expression)
- expression 표현식은 표현하려는 대상이 필요 => 결과(값)를 표현하는 식 => 치환
```
def get(num) = num match { ... }
class Main extends App {
    get(1) // "one" 으로 치환
}
```

> ### 정리
> * switch가 match로 바뀐건 match가 더 맞는 표현이라서다.
> * break가 사라진건 많은 자바인들이 원했던 것이다.
> * : 가 => 바뀐것, _를 사용하는 것은 case 문 자체가 함수이기 때문이다.
> * match - case가 결과를 반환하는 것은 함수 언어의 특성때문이다.

## type Match
one이란 값이 Int라면 "숫자", String이면 "문자"라고 반환하기를 원한다면?
```
val str = one match {
    case Int => "숫자"
    case String => "문자"
}
// MatchError 발생
```
case 문은 함수다.
```
val str = one match {
    case n : Int => "숫자"
    case s : String => "문자"
}
```
one이 숫자인 경우, 5보다 작으면 "작은 숫자" 5보다 크면 "큰 숫자" 라고 반환하기를 원한다면?
```
val str = one match {
    case n : Int => if (n > 5) "큰 숫자" else "작은 숫자"
    case s : String => "문자"
}
```
더 깔끔한 방법이 있다.
```
val str = one match {
    case n : Int if n > 5 => "큰 숫자"
    case n : Int if n <= 5 => "작은 숫자"
    case s : String => "문자"
}
```

## Collection Match
list의 첫번째 원소가 0인지 확인하고 싶을 때,
```
list match {
    case 0 :: tail => "0으로 시작한다"
    case _ => "0으로 시작하지 않는다"
}
```
만약 두번째 원소가 0인지 확인하고 싶다면,
```
list match {
    case x :: 0 :: tail => s"2번째 원소가 0이다."
    case _ => "그 외..."
}
```

## case class
패턴 매칭과 동작하는데 최적화된 케이스 클래스
```
class Email(id : String, domain : String)
val mail = new Email("gift", "daum.net")

mail match {
    case e : Email => s"주소는 ${e.id}@${e.domain}입니다."
}
```
더 깔끔한 방법이 있다.
```
case class Email(id : String, domain : String)
val mail = Email("gift", "daum.net")

mail match {
    case Email(i, d) => s"주소는 ${i}@${d}입니다."
}
```
함수 모양이 이상하다...

## 추출자
case 클래스 없이 직접 구현해보면...
```
class Email(val id : String, val domain : String)
object Email {
  def apply(id, domain) = new Email(id, domain)
  def unapply(e : Email) = Some(e.id, e.domain)
}
val mail = new Email("gift", "daum.net")

mail match {
  case Email(i, d) => s"주소는 ${i}@${d}입니다."
}
```
Email(i,d)는 Email.apply(i,d) 와 동일??
```
object Email {
  def apply(id, domain) = new Email(id, domain)
  def unapply(e : Email) = Some(e.id, e.domain)
}

case Email(i, d) => Email(i, d)
// Email.unapply(email) => Email.apply(i, d)
```
- 모양은 동일하나 case 문 왼쪽에서는 email 객체를 받아서 id와 domain을 추출하는 unapply 호출
- case문 오른쪽에서는 Email을 생성하는 apply를 호출.

