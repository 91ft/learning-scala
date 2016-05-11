# 연산자

연산자를 직접 구현해보자.
보통 도메인 언어를 만드는데 사용된다
암묵변환은 도메인 언어의 생성을 가능케 한다

- 인식자는 숫자 연산자 문자 포함할수 있다
- 삽입 연산자는 메소드 콜
- 우선순위는 첫번째 문자가 결합성은 마지막 문자가 결정
- expr(args) 계산할때 apply 와 update 메소드가 호출
- 추출자는 입력에서 튜플이나 값의 시퀀스를 뽑아낸다


http://prof.dongju.ac.kr/syhong/public_html/teaching/c/c04.htm

## 인식자
변수, 함수, 클래스 등의 이름을 인식자라 부름. 자바보다 인식자 허용 폭이 넓어서 수학 부호도 가능.

```
val √ = scala.math.sqrt _
√(2)
```
```
val 'val' = 1
Thread.'yield'()  // 구세주
```

## 삽입 연산자
연산자가 인자 사이에 있어서 삽입 표현식이라고 부름
```
1 to 10
1.to(10)
```
```
1 -> 10
1.->(10)
```

## 단항 연산자
인자가 하나인 연산자
```
// 후위 연산자
1 toString
1.toString()
```
```
// +, -, !, ~ 는 전위 연산자가 될 수 있음
-a
a.unary_-
```

## 할당 연산자
```
a += b
a = a + b
```

## 우선순위
두개 이상의 연산자가 연속으로 있으면 우선순위 높은 연산자부터 실행
후위 연산자는 삽입 연산자에 비해 우선순위가 낮음 p.133

## 결합성
같은 우선순위 연산자가 있으면 결합성으로 방향 결정  
1. 콜론 : 으로 끝나는 연산자
2. 할당 연산자
를 제외하고 모두 왼쪽으로 결합한다.
```
3 + 2 * 5 :: Nil
// Quiz. 결과?
```

## apply와 update 메소드
```
f(arg1)
f.apply(arg1)
```
```
f(arg1) = value
f.update(arg1, value)
```
배열과 맵에 사용
```
val scores = new mutable.HashMap[String, Int]
scores("BigBoss") = 100
scores.update("BigBoss", 100)
//
val bigBossScore = scores("BigBoss")
val bigBossScore = scores.apply("BigBoss")
```
apply는 컴패니언 오브젝트에도 사용
https://github.daumkakao.com/Gift/study-scala/tree/master/src/main/scala/ScalafortheImpatient/ch06#컴패니언-오브젝트

```
class Alpha(n: Int, d: Int) {
...
}

object Alpha {
   def apply(n: Int, d: Int) = new Alpha(n, d)
}
// apply 메소드 덕분에 new Alpha(3, 4) 대신 Alpha(3, 4)로 생성할 수 있음
```

## 추출자. Extractors
unapply 메소드가 있는 오브젝트
`apply` 메소드는 생성 파라미터를 받아서 오브젝트를 생성
`unapply` 메소드는 오브젝트에서 값을 뽑아냄 (보통 오브젝트 생성시 사용된 값들)
패턴 매칭에서 구조를 분해하는데 주로 사용됨. 매치가 시도될때 자동적으로 unapply()가 호출되어 input 을 파라미터로 전달함
```
case Alpha(a, b) => ...
// 패턴 매치는 실패할 수 있으므로 unapply는 Option을 리턴함
// 여기서는 Option[(Int, Int)] 를 리턴
```

```
object Test {
    def unapply(a: Int): Boolean = {
        if (a < 10) { true }
        else { false }
    }
}

class Example {
    def method(target: Int) {
        target match {
            case Test() => println("matched to Test")
            case 120 => println("match to 120")
        }
    }
}

val t = new Example
t.method(5)
```
추출자를 사용해서 어떤 타입의 오브젝트에서든 정보를 뽑아낼 수 있다
```
val bigBoss = "Song Junggi"
val Name(first, last) = bigBoss

object Name {
  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }
}
```

## unapplySeq 메소드
unapply 메소드에서는 고정된 수의 엘리먼트를 반환하기 때문에 _* 를 사용할 수 없다
다양한 아규먼트의 매칭을 위해 unapplySeq 메소드 호출이 필요.
unapplySeq 메소드는 임의의 엘리먼트 타입 A를 가진 Option[Seq[A]] 를 리턴
```
object Name {
   def unapplySeq(input: String): Option[Seq[String]] =
      if (input.trim == "") None else Some(input.trim.split("\\s+"))
}

bigBoss match {
   case Name(first, last) => println("1")
   case Name(first, middle, last) => println("2")
   case Name(first, "van", "der", last) => println("3")
}
```





