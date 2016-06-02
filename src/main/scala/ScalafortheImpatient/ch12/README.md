# Chapter 12. 고차 함수

함수형 언어는 다른 모든 데이터 타입과 마찬가지로 주고 받고 조작할수 있는 1등 시민이다.
자바에서는 객체와 원시값을 메서드에전달했었지만.
함수형 언어에서는 함수도 전달 가능


- 스칼라에서는 함수도 1등시민
- 보통 다른 함수에 인자로 넘길때 익명함수를 생성할수 있다.
- 함수 인자는 나중에 실행될 행동을 지정한다.
- 많은 콜렉션 메소드는 함수 인자들을 받아서 함수를 콜렉션의 값들에 적용한다.
- 함수인자를 더 쉽고 짧게. 단축 문법

<hr />



## 1. 값으로서 함수
```
 스칼라에서 함수는 숫자와 마찬가지로 1등시민, 함수를 변수에 저장 가능
```


## 2. 익명 함수
스칼라에서는 각 함수마다 이름을 줄 필요는 없다.=> 익명함수
```
(x:Double) => 3*x // 이 함수에 인자에 3을 곱한다.
```

변수에 저장도 가능
```
val triple = (x:Double) => 3*x
```

이는 def: 를 사용한것과 마찬가지
```
def triple(x: Double) = 3*x
```

하지만 꼭 함수 이름을 줄 필요는 없다, 그냥 다른 함수에 넘길수도 있다.

```
Array(3.14, 1.23,2.0).map( (x:Double) => 3*x ) // Array(9,42, 3.69, 6.0)
```


```
취향에 따라 () 대신  { }중괄호를 사용하기도,
Array(3.14, 1.42, 2.0).map{ (x:Double) => 3*x }
Array(3.14, 1.42, 2.0) map{ (x:Double) => 3*x }
점 없는 메소드 표기법을 사용할때 보통 씀.
```
그냥 하던대로 하자.


## 3. 함수 인자를 받는 함수

다른 함수를 인자로 받는 함수를 구현하는 법
```
def valueAtOneQuarter(f: (Double) => Double)  = f(0.25)
```

인자는 Double를 받아서 리턴하는 어떤 함수도 될수 있다.
```
ex)
 valueAtOneQuarter(ceil _)
 valueAtOneQuarter(sqrt _)

```

valueAtOneQuarter 이 함수는 함수를 받는 함수 이기 때문에 고차 함수라고 불린다.

## 4. 인자 추론

스칼라는 가능하면 타입을 추론하여 도움을 준다.

## 5. 유용한 고차 함수

콜렉션 라이브러리 메소드들

## 6. 클로저
```
def mulBy(factor : Double) = (x : Double) => factor *x
val triple = mulBy(3)
val half = mulBy(0.5)
print (triple(14) * half(14))

```
느린동작으로 보자

```
- mulBy첫 번째 호출은 인자 변수 factor 를 3으로 설정한다. 이 변수는 triple에 저장되는 함수의 바디

x:Double => factor * x 에서 참조된다. 그러고 나서 인자 변수 factor은 런타임 스택에서 제거된다.

- 다음으로 mulBy가 다시 호출되었을때, factor=0.5로 설정된다. 이 변수는 half에 저장되는 함수 바디 x:Double => factor *x에서 참조된다.

```

리턴된 함수들은 각각 자신의 factor 설정을 가진다.
이런 함수를 클로저라 부른다.
클로저는 코드와 함께 코드를 사용하는 비지역 변수의 정의들로 구성된다.

## 7. 커링

   커링은 인자 두개를 받는 함수를 인자 하나를 받는 함수로 바꾸는 프로세스다.
   이 함수는 두번째 인자를 소비하는 함수를 리턴한다.

   ```
   def mul(x: Int, y:Int) = x*y
   ```

   이 함수는 인자 하나를 받아서  인자 하나를 받는 함수를 리턴한다.
   ```
   def mulOnAtATime(x:Int)=(y:Int) => x*y
   ```

   두개의 숫자를 곱하려면
   mulOnAtATime(4)(5)

   mulOnAtATime(4) 의 결과는 (y:Int) => 4*y 함수이다.
   이 함수에 인자 7을 받으면 28이나온다.
   스칼라에서는 이런 커리 함수를 정의하는 단축이 있다.

   ```
   def mulOnAtATime(x:Int)(y:Int) = x*y

   val a = Array("Hello", "World")
   val b = Array("hello", "world")
   a.corresponds(b)(_.equalsIgnoreCase(_))

```


## 8. return 표현식
함수 값을 리턴하기 위해 return문을 사용하지 않는다.
함수의 리턴 값은 단순히 함수 바디의 값이다.

익명함수에서 이름 있는 함수에 값을 리턴하기 위해 return을 사용할수 있다.

   ```
   def indexOf(str: String, ch:Char):Int ={
    var i=0
   until( i== str.length){
        if( str(i) == ch) return i
        i+= 1
   }
   return -1
   }
   ```

   return  표현식이 실행될때, 바깥의 이름있는 함수 indexOf는 종료되고 주어진 값을 리턴한다.
   이름있는 함수에서 return을 사용할때는 리턴 타입을 지정해 줘야 한다.
   indexOf함수에서는 컴파일러는 이 함수가 Int를 리턴함을 추론하지 못함.

   ```
   어떻게 하면 reductLeft로 배열의 가장 큰 원소를 얻을수 있는가.
   ```



## 별책 부록
```
 스칼라에서 _ 의 의미를 낱낱이 파헤쳐본다
```

1. Import all

```
 import scala.util.control.Breaks._
 ```
2. default value
 단, 생성자에서만! 함수 노!
```
class Foo {
    var i:Int = _ // i = 0
    var s:String = _ // s = null

    def f {
    // var i:String = _//error: local variables must be initialized
    }
}
```

3. Unused variables

```
 def inPatternMatching2(s:String) {
    s match {
        case "foo" => println("foo !")
        case _ => println("not foo")
    }
}
```

4. Anonymous parameters //param이 명확할때.

```
(1 to 10) map { x => x + 1}
(1 to 10) map { _ + 1}
(1 to 10).foldLeft(0) { (x,y) => x+y }
(1 to 10).foldLeft(0) { _+_ }
```

5. Don’t import name in namespace
 콜렉션의 Map관련 메소드들은 임포트 하지마라
```
import collection.{ Map => _ , _ }
```

6. Syntactic sugar for existential type
```
import scala.mah._
var calc = ceil _
```

특정 타입을 지칭하는거 . 위에서 내려온 타입을 그대로 쓰겠다
**[마틴 아저씨 existential type](http://www.artima.com/scalazine/articles/scalas_type_system.html)**

 
<hr/>

