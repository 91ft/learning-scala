# Chapter 6. 오브젝트

## Java Style
스칼라에서는 static이 없다. static이 필요한 경우가 있다면?

## 싱글톤
스칼라에서는 static이 없는 대신 object를 제공한다.
```scala
object AdminFactory {
  def create(name : String) : Admin = new Admin(createUniqId(), name)
}

val newAdmin = AdminFactory.create("김수현")
```

## apply
메소드 하나만 달랑 있는 경우라면, apply 메소드를 사용하면 메소드명을 생략할 수 있다.
(자바에서 HtmlEscape.escape(...), Job.do(...) 이렇게 의미없는 메소드 명을 사용해왔다면, 스칼라에서는 apply를 사용해서 생략할 수 있다.)
```scala
object AdminFactory {
  def apply(name : String) : Admin = new Admin(createUniqId(), name)
}

val newAdmin = AdminFactory("김수현") // == AdminFactory.apply("김수현")
```
당신은 이미 apply를 사용하고 있다.
```scala
val func1 = (msg : String) => s"[출력1] $msg"
func1("글을 쓴다")
func1.apply("성공!")

val func2 = new PartialFunction[String, String] {
  override def apply(msg : String): String = s"[출력2] $msg"
}
func2("글을 쓴다")
func2.apply("성공!")

```

## 컴패니언 오브젝트
자바나 C++에서 클래스가 인스턴스 메소드와 static 메소드를 모두 갖는 대신
스칼라에서는 컴패니언 오브젝트를 사용하여 이런 효과를 낼 수 있다.
컴패니언 오브젝트는 private 변수에 접근할 수 있다.
```scala
object Admin {
  def apply(name : String) : Admin = new Admin(createUniqId(), name)
}

val newAdmin = Admin("김수현")
```

| Java Style | Scala Style |
| --- | --- |
| val newAdmin : Admin = (new AdminFactory).create("김수현") | val newAdmin : Admin = Admin("김수현")

당신은 이미 컴패니언 오브젝트를 사용하고 있다.
```scala
scala> var list = List(0,1,2) // new List()로 생성을 하고 있지 않았음
list: List[Int] = List(0, 1, 2)


class List
object List
```

## class와 trait를 확장
object는 클래스나 trait를 상속받을 수 있다
```scala
object BotAdmin extends Admin(0L, "봇 운영자") with SendWatchTower
```

## 이뉴머레이션
스칼라에서는 Enumeration 타입이 없다. 대신 enum과 같은 기능을 할 수 있는 Enumeration 라이브러리를 제공한다
```scala
object AdminType extends Enumeration {
  val System, CS_Manager, Reporter = Value
}

class Admin(adminType : AdminType.Value)

Admin(AdminType.Reporter, "김수현")
```

> ## 정리
> #### object
> * 스칼라에서는 static 대신 object를 사용한다.
> * class와 이름이 같은 object를 컴패니언 오브젝트라고 하며, private 변수에 접근할 수 있다.
> * object는 class와 trait 상속받을 수 있다.
>
> #### object과 종종 같이 쓰이는 것들
> * apply 메소드는 생략할 수 있다.
> * enum 대신 Enumeration 라이브러리를 제공한다.

