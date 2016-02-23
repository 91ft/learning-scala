# Chapter5. 클래스

## 5.1 간단한 클래스와 인자 없는 메소드
```
class Counter {
  private var value = 0
  def increment() = {
    value += 1
  }
  def current() = value
}

val myCoucnter = new Counter()
myCoucnter.increment() // accessor method 
myCoucnter.current // mutator method
```

- 클래스는 public으로 선언되지 않음. (모든 클래스가 public 가시성임)
- 클래스를 사용하려면 일반적인 방법으로 오브젝트를 생성하고 메소드를 호출한다.
- 오브젝트 상태를 변경하지 않는 메소드는 ()를 생략. accessor method 
- 오브젝트의 상태를 바꾸는 경우 ()를 사용. mutator method
- 예제 : ScalafortheImpatient.ch05.Counter


## 5.2 게터와 세터가 있는 프로퍼티
- 스칼라는 모든 필드에 대해 getter/setter method를 제공한다!!
    - 필드가 비공개이면 게터와 세터는 비공개이다
    - 필드가 val이면 게터만 생성된다
    - 게터나 세터가 필요없으면 필드를 private[this]로 선언한다
- 스칼라에서 게터와 세터 메소드는 age와 age_=로 불린다
- tip
    - 필드가 비공개이면 게터와 세터는 비공개다
    - 필드가 val이면 게터만 생성된다
    - 게터나 세터가 필요 없으면 필드를 private[this]로 선언한다
- 예제 : ScalafortheImpatient.ch05.Person
- 예제 : ScalafortheImpatient.ch05.Person2 
- 예제 : ScalafortheImpatient.ch05.Person3 

## 5.3 게터만 있는 프로퍼티
- val 필드를 사용하면 된다
- 클라이언트는 마음대로 볼 수 없지만 어떤 다른 방법으로 수정되는 프로퍼티가 필요한 경우?
    - 필드는 private로 하고 별도의 함수를 제공하면 된다. ex) Counter의 increment()
   

## 5.4 오브젝트-비공개 필드
- private[this]
- 아예 게터와 세터를 생성하지 않는다
- 예제 : ScalafortheImpatient.ch05.Counter2


## 5.5 빈 프로퍼티
- 자바 프로퍼티를 위한 getFoo/setFoo 형태의 메소드 쌍을 정의하려면?
- @BeanProperty 주석을 달아주면 된다
- 예제 : ScalafortheImpatient.ch05.Person4


## 5.6 보조 생성자
- 보조생성자는 this라고 불린다
- 각 보조 생성자는 반드시 이전에 정의한 보조 생성자나 기본 생성자 호출로 시작해야 한다
- 예제 : ScalafortheImpatient.ch05.Person5


## 5.7 기본 생성자
- 모든 클래스는 스칼라에서 기본 생성자를 가진다
- 기본 생성자는 this 메소드로 정의하지 않는다
- 대신 기본 생성자는 클래스 정의와 뒤섞인다
- 기본 생성자는 클래스 정의에 있는 모든 문을 실행한다
- 기본 생성자가 헛갈리면 보조 생성자를 쓰면 된다.
- Martin Odersky said, "클래스는 스칼라에서 메소드와 마찬가지로 인자를 받는다"
- 예제 : ScalafortheImpatient.ch05.Person6


## 5.8 중첩 클래스
- 클래스를 다른 클래스 안에 정의할 수 있다.
- 스칼라에서 각 인스턴스는 각자 자신의 members필드를 갖는 것처럼 각자 자신의 Members클래스를 갖는다
- 예제 : ScalafortheImpatient.ch05.Network
- 예제 : ScalafortheImpatient.ch05.Network2
- 예제 : ScalafortheImpatient.ch05.Network3
