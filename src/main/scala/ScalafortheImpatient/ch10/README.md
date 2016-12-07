# Chapter10. 트레이트

## 10.1 왜 다중 상속을 사용하지 않는가?
- 다중상속을 지원하지 않는 이유
    - 예를 들어 조교는 학생이면서 동시에 근로자다. class로 표현했을 때, 두 개의 id 메소드를 상속받을 수 있다
    - 다이아몬드 상속 문제를 일으킨다. 두 개의 name 메소드를 원하지 않음.
    - 자바설계자들은 이런 복잡성을 두려워하며 매우 제한적인 접근 방법을 취했다
- 어떤 메소드를 다른 메소드를 이용해 구현할 필요가 있을 땐 어떻게 하나?
- 추상 베이스 클래스 2개를 상속할 필요가 있으면 어떻게 하나?


## 10.2 인터페이스로서 트레이트
- 스칼라 트레이트는 자바인터페이스와 정확히 똑같이 동작할 수 있다
- 몇 가지 개발 규약
    - 트레이트에서 구현되지 않은 메소드는 자동으로 abstract이다. 키워드 붙일 필요 없음.
    - trait의 추상메소드를 오버라이드할 때, override 키워드를 제공할 필요 없다.
    - 하나 이상의 trait가 필요하면, with 키워드로 더해준다.
```
trait Logger {
  def log(msg: String)
}

class ConsoleLogger extends Logger with Cloneable with Serializable {
  def log(msg: String) = { println(msg) }
}

```


## 10.3 구체적 구현이 있는 트레이트
- 스칼라에서 트레이트의 메소드는 추상일 필요가 없다
- 아래 예제는 스칼라에서 ConsoleLogger기능이 SavingsAccount클래스에 '믹스인'되었다고 이야기한다
- (주의) 한가지 단점은 구체적인 구현이 있는 트레이트가 변경되면 이 트레이트를 믹스인한 모든 클래스가 다시 컴파일 되야 한다.
```
trait ConsoleLogger {
  def log(msg: String) = { println(msg) }
}

class Account {
  var balance: Double = 0
}

class SavingAccount extends Account with ConsoleLogger {
  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient founds")
    else balance -= amount
  }
}
```

## 잠깐! 트레이트를 왜 믹스인해서 쓰나?
- 믹스인하여 사용하면 코드 반복을 줄일 수 있다
- 간결한 인터페이를 믹스인하여 풍부한 인터페이스로 만들 수 있다. (PiS 12장. Rectangular 예제 참조)
- 풍부한 인터페이스를 이용하면 편리해지는 또 다른 영역으로 "비교(compare)"가 있다.
    - 이건 너무 자주 쓰여서 스칼라에서는 Ordered 트레이트를 제공한다
    - PiS 12장의 Rational 예제 참조
- Ordered trait를 사용하는 방법
    - 딱 2가지만 하면 된다.
    - 1. Ordered를 믹스인 할 때 Ordered[C]와 같이 비교하고자 하는 클래스 C를 명시해야 한다
    - 2. 두 객체를 비교하는 compare 메소드를 정의한다


## 10.4 트레이트가 있는 오브젝트
- 트레이트를 믹스인 하여 트레이트를 확장할 수 있다.
- ex) val acct2 = new SavingAccount with ConsoleLogger
- 가장 마지막에 추가된 trait가 실행된다. 순서가 중요!!
- Quiz. 아래 코드 실행하면 어떻게 나올까요?
- <img src="https://openclipart.org/image/200px/svg_to_png/194097/googley-eye-birdie-has-questions.png" />
```
trait Logged {
  def log(msg: String) {}
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) = { println(msg) }
}

class Account {
  var balance: Double = 0
}

class SavingAccount extends Account with Logged {
  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient founds")
    else balance -= amount
  }
}
```


## 10.5 레이어드 트레이트
- super.log는 트레이트가 더해지는 순서에 의해 결정되는 트레이트 계층도에서 다음 트레이트를 호출한다.
- 일반적인 트레이트는 마지막 것부터 처리된다
- Quiz. acct3, acct4 리턴값은 각각 어떻게 될까? 이제 눈치 채셨죠?!
- <img src="https://openclipart.org/image/200px/svg_to_png/183310/googley-eye-bird-pink.png" />
```
val acct3 = new SavingAccount with ConsoleLogger
  with TimestampLogger
  with ShortLogger

val acct4 = new SavingAccount with ConsoleLogger
  with ShortLogger
  with TimestampLogger
```


## 10.6 트레이트의 추상 메소드 오버라이드하기
- 추상 메소드를 상속받은 trait는 컴파일 오류 발생
- 어떤 메소드가 믹스인되는지 알 수 없음
- 컴파일러는 구체적인 메소드가 믹스인 되기를 요구한다.
- 구현부 없는 메소드인 경우 abstract override 키워드를 붙여줍니다.
- 선형화(linearization)가 중요 함! 
- ex) http://stackoverflow.com/questions/32511722/stackable-traits-pattern-methods-implementation-needs-abstract-override-mo


## 10.7 리치 인터페이스를 위한 트레이트
- 한 trait에 추상메소드와 구체메소드가 조합되어 구현될 수 있음
- 트레이트에서 구체메소드와 추상메소드의 이용은 스칼라에서 매우 흔하다
- 위에서 이미 한 얘기임

## 10.8 트레이트의 구체 필드
- trait를 믹스인하는 클래스는 구체필드를 획득한다
- 필드를 상속받는것이 아니라 단순히 서브 클래스에 추가된다
- JVM에서는 클래스가 오직 하나의 슈퍼클래스만 확장할 수 있다
- 따라서 trait의 구체필드는 하위클래스에 조합된다
```
balance -- Superclass object
-------
interest   -- Subclass fields
maxLength
```


## 10.9 트레이트의 추상 필드
- trait에서 초기화되지 않은 필드는 추상이다
- 구체 클래스에서 반드시 필드값을 제공해야 한다
- 이런 방식은 오브젝트를 그때그때 생성할때 편리하다
```
val acct9 = new SavingAccount with ConsoleLogger with ShortLogger {
  val maxLength = 20
}
```


## 10.10 트레이트 생성 순서
- Super Class 생성자 호출
- 트레이트 생성자는 Super Class 생성자 이후, Class 생성자 전에 실행
- 트레이트는 왼쪽에서 오른쪽으로 생성된다
- 각 트레이트에서 부모가 먼저 생성된다
- 여러 트레이트가 공통의 부모를 공유하고 부모가 이미 생성되었으면 다시 생성하지 않는다
- 모든 트레이트가 생성된 후, 서브클래스가 생성된다
- 예시1
```
class SavingsAccount extends Account with FileLogger with ShortLogger

1. Account (Super Class)
2. Logger (첫번째 트레이트의 부모)
3. FileLogger (첫번째 트레이트)
4. ShortLogger (두번째 트레이트). Logger부모는 이미 생성되었으므로 pass~
5. SavingsAccount (클래스)
```
- 또 다른 예시
```
class Animal
trait Furry extends Animal
trait HasLegs extends Animal
trait FourLegged extends HasLegs
class Cat extends Animal with Furry with FourLegged
```
- 선형화 : 어떤 타입의 모든 슈퍼타입의 기술명세
- 그림 참조 
 - ![선형화](https://github.com/91ft/learning-scala/blob/master/src/main/scala/ScalafortheImpatient/ch10/Cat%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%E1%84%8B%E1%85%B4%20%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8%20%E1%84%80%E1%85%A8%E1%84%8E%E1%85%B3%E1%86%BC%E1%84%80%E1%85%AA%20%E1%84%89%E1%85%A5%E1%86%AB%E1%84%92%E1%85%A7%E1%86%BC%E1%84%92%E1%85%AA.png)
 - Cat -> FourLegged -> HasLegs -> Furry -> Animal -> AnyRef -> Any
    
    
## 10.11 트레이트 필드 초기화
- 트레이트는 생성인자를 가질 수 없다
- 생성인자의 부재가 클래스와 트레이트의 유일한 기술적 차이점이다
- 대체방법1. 익명 서브클래스로 필드 초기화 - 조기 정의
    - 조기정의는 생성 순서 전에 일어난다.
- 대체방법2. trait 생성자에 레이지값을 쓰는 것
    - 해당 필드가 처음 사용될 때 초기화 된다.
    - 하지만 레이지값은 사용할 때마다 초기화를 확인하므로 비효율적이다
    

## 결론
- 트레이트는 다중상속과 비슷하다.
- 하지만 선형화를 통해 super를 해석하기 때문에 다중상속의 몇가지 어려움을 피한다.
- 원하는 기능을 스택처럼 쌓아올릴 수 있다. (쌓을 수 있는 변경. stackable modification)
- 트레이트는 상속을 통해 재사용할 수 있는 기본 코드 단위이다. 간단한 개념조각을 담는다.
- 이런 특성 때문에 경험있는 스칼라 프로그래머들은 구현 초기에 트레이트로 시작하는 경우가 많다.
- 설계를 구체적으로 진행해가면서 각 조각을 믹스인해서 좀 더 완전한 개념으로 조합할 수 있다.

## 보너스. 트레이트냐 아니냐, 이것이 문제로다
- 재사용 가능한 행위를 구현할 때, trait를 쓸지 abstract를 쓸지 고민된다면 아래 가이드라인을 참고해보자
    - 어떤 행위를 재사용하지 않을 거라면? class로 만들어라
    - 서로 관련이 없는 클래스에서 어떤 행위를 여러 번 재사용해야 한다면? trait. 믹스인 가능한것은 트레이트 뿐이니까
    - 자바 코드에서 스칼라의 내용을 상속해야 한다면? abstract class. 자바에는 trait개념이 없기때문
    - 컴파일한 바이트코드 형태로 배포할 예정이고, 배포한걸 누군가 상속한다면? abstract class.
        - trait를 상속하는 모든 클래스는 그 자신의 변경 여부와 관계없이 다시 컴파일해야만 한다
    - 효율이 중요하다면? class를 좀 더 사용하라. 
        - trait는 인터페이스가 되기 때문에 약간의 성능상 부가비용이 존재한다
    - 여기까지 설명한 내용 모두 고려했는데 여전히 판단이 서지 않는다면?
        - trait!! 언제든지 바꿀 수 있으며 보통 trait가 더 많이 쓰이니까
    
