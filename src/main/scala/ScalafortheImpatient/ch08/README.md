# Chapter8. 상속

## 8.1 클래스 확장하기
```
class Country {
  override def toString = "[Country]" + getClass.getName
}

class Baekjae extends Country {
  override def toString = super.toString + ">> [Baekjae]"
}
```
- 자바처럼 extends 키워드로 클래스 확장

## 8.2 메소드 오버라이드하기
- 추상 메소드가 아닌 메소드를 오버라이드 할 때 반드시 override 수정자를 사용해야 한다
- override 사용 시 아래와 같은 일반 상황에서 유용한 에러 메시지를 줄 수 있다
    - 오버라이드하는 메소드의 이름에 오타가 있을 때
    - 오버라이드하는 메소드에 인자 타입을 실수로 잘못 줬을 때
    - 서브클래스 메소드와 충돌하는 새로운 메소드를 슈퍼클래스에 추가했을 때
- 스칼라에서 슈퍼클래스 메소드 호출은 자바와 동일하게 super를 사용함
    
## 8.3 타입 검사와 캐스트
```
val baekjae : Baekjae = new Baekjae("백제")
val c : AnyRef = baekjae

// example1
if (c.isInstanceOf[Baekjae]) {
  val s = c.asInstanceOf[Baekjae] //c는 Baekjae 타입
}

// example2
c match {
  case b: Baekjae => println("Wow! Baekjae!")
  case _ => println("Where am I?")
}
```
- isInstanceOf : 오브젝트가 특정 클래스에 속하는지 테스트할 때
- asInstanceOf : 레퍼런스를 서브클래스 레퍼런스로 변환
- 보통 패턴매칭이 타입검사와 캐스트 사용보다 더 좋은 대안이다.

## 8.4 보호 필드와 메소드
- 자바처럼 필드나 메소드를 protected로 선언할 수 있다
- 서브클래스에서는 접근 가능하나 다른 곳에서는 접근 불가능

## 8.5 슈퍼클래스 생성
- 클래스는 하나의 기본 생성자와 여러 보조 생성자가 있다
- 모든 보조 생성자는 앞선 보조생성자나 기본 생성자 호출로 시작해야만 한다. 이건 규칙~!
- 따라서 오직 기본 생성자만이 슈퍼 클래스 생성자를 호출할 수 있다.
```
class Koguryo(name: String, center: String) extends Country(name)
```
- 위 예에서 클래스 인자는 기본 생성자 인자라고 생각하면 쉽다.
- Koguryo 클래스는 name, center 두 개의 인자를 가지고 그 중 name은 슈퍼클래스 Country로 전달한다.
- 스칼라는 자바처럼 super(params)형태로 호출하진 않는다.

## 8.6 필드 오버라이드하기
```
8_6_example.sc참조
```
- def는 오직 다른 def만 override 할 수 있다
- val은 다른 val이나 인자없는 def만 override 할 수 있다
- var은 오직 추상 var만 override 할 수 있다

## 8.7 익명 서브클래스
```
8_7_example.sc참조
```
- 정의나 오버라이드가 있는 블록을 포함하면 익명 서브클래스의 인스턴스를 생성한다
- 구조타입의 오브젝트를 생성하게 된다 (자세한 내용은 18장에서 공부할 예정 임)

## 8.8 추상 클래스
```
abstract class Element {
    def contents: Array[String]
}
```
- 구현이 없는 메소드가 있음을 나타냄
- 인스턴스화 할 수 없는 클래스를 나타낼 때 abstract키워드를 사용함
- 클래스에 abstract 키워드 사용. 
- 추상 메소드에는 abstract 키워드를 사용하지 않는다. 단순히 바디만 생략

## 8.9 추상 필드
```
abstract class Element {
  val id: Int
  var name: String
  def contents: Array[String]
}
```
- 단순히 초기 값이 없는 필드

## 8.10 생성 순서와 조기 정의
```
class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

```
- 퀴즈. env의 length는 얼마일까요?

- val을 final로 선언한다. 매우 안전 하지만 유연하지 못함
- val을 슈퍼클래스에서 lazy로 선언한다. 안전하지만 약간 비효율적
- 서브클래스에서 조기 정의 문법을 사용한다. 오호라!

```
class Bug extends {
    override val range = 3
} with Creature
```
- 조기정의
    - 서브클래스의 val필드를 슈퍼클래스가 실행되기 전에 초기화 할 수 있게 해준다

## 8.11 스칼라 상속 계층
![Scala Hierarchy Tree](http://insaneguy.me/imgs/scalaclasshierarchy.png)
- Any 
    - 센터! 모든 클래스가 Any의 서브클래스
    - Any에 정의한 메소드는 모두 '보편적인'메소드. 어느 객체에서나 호출할 수 있다.
    - http://www.scala-lang.org/api/2.11.8/index.html#scala.Any@asInstanceOf[T0]:T0
    ```
    scala> 42.toString
    scala> 42.hashCode
    scala> 42##
    scala> 42 equals 42
    ```
- AnyVal : 모든 스칼라의 내장 값 클래스. value class의 부모 클래스다.
    - 각각의 값 타입은 서로 상속 관계가 없다
    - 대신 값 클래스 타입 사이에 암시적인 변환을 제공한다
    - ex) scala.Int의 인스턴스는 필요할 때마다 자동으로 scala.Long클래스의 인스턴스로 widening을 함. (암시적인 변환 사용)
    - ex) Int를 RichInt로 암시적 변환을 시키는 등등
- AnyRef : 스칼라의 모든 참조 클래스의 기반 클래스이다.
    - AnyRef는 java.lang.Object에 별명을 붙인 것에 지나지 않는다
    - 자바로 작성한 클래스나 스칼라로 작성한 클래스는 모두 AnyRef를 상속한다
    - 따라서 자바플랫폼의 스칼라 프로그램에서는 AnyRef를 Object로 바꿔 사용할 수 있다 (헛갈리니 그러지는 말자
    - 스칼라 객체는 ScalaObject라는 스칼라 객체를 표시하기 위한 특별한 trait를 상속한다는 점이 자바객체와 차이가 있음.
- Nothing, Null : 스칼라 맨 밑바닥에 있는 클래스
    - Null : AnyRef를를 상속한 모든 클래스의 서브클래스
    - Nothing : 모든 스칼라 클래스 계층의 맨 밑바닥. Nothing의 쓸모는 비정상적인 종료를 표시하는 경우 유용함

    
## 8.12 오브젝트 등식
- 스칼라의 동일성 연산 ==는 타입의 표현과 관계없이 투명하게 동작한다
    - 값 타입의 경우 ==는 수 혹은 참 값을 비교하는 동일성
    - 참조 타입의 경우 ==는 Object에서 상속한 equals 메소드의 별명
    - 만약 참조 동일성을 체크한다면 eq 혹은 ne를 사용하면 된다
- equals를 재정의하는 건 위험하므로 가급적 피하자.
