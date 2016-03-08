# Chapter6. 오브젝트

## 싱글톤
스칼라에서는 static이 없다. 대신 object를 사용한다.
```scala
object AdminFactory {
  def create(name : String) : Admin = new Admin(createUniqId(), name)
}

val adminFactory = new AdminFactory
val newAdmin = adminFactory.create("김수현")
```

## apply
apply 메소드를 사용하면 메소드명을 생략할 수 있다
```scala
object AdminFactory {
  def apply(name : String) : Admin = new Admin(createUniqId(), name)
}

val adminFactory = new AdminFactory
val newAdmin = adminFactory("김수현")
```

## 컴패니언 오브젝트
자바나 C++에서 클래스가 인스턴스 메소드와 static 메소드를 모두 갖는 대신
스칼라에서는 컴패니언 오브젝트를 사용하여 이런 효과를 낼 수 있다.
```scala
object Admin {
  def apply(name : String) : Admin = new Admin(createUniqId(), name)
}

val newAdmin = Admin("김수현")
```

| Java Style | Scala Style |
| --- | --- |
| val newAdmin : Admin = (new AdminFactory).create("김수현") | val newAdmin : Admin = Admin("김수현")

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

