# Chapter 13. 콜렉션

스칼라 콜렉션 라이브러리에 대하여...

- 모든 콜렉션은 Iterable 트레이트를 확장한다.
- 스퀀스(Seq), 집합(Set), 맵(Map)
- 수정 가능한 버전과 수정 불가능한 버전을 가지고 있다. (mutable/immutable)
- 리스트는 비었거나, head(원소)와 tail(리스트)을 가짐.
- 집합(Set)은 순서가 없는 콜렉션이다.
- 순서 유지 : LinkedHashSet, 항상 정렬된 순서 : SortedSet
- +는 순서 없는 콜렉션의 원소를 더한다.
- +:는 시퀀스 앞에, :+는 스퀀스 뒤에 원소를 더한다.
- ++는 두 개의 콜렉션을 병합한다.
- -와 --는 원소를 제거한다.
- Iterable과 Seq 트레이트는 유용한 메소드들을 가지고 있다.
- 매핑, 폴딩, 지핑은 함수나 연산을 콜렉션의 원소들에 적용하기에 유용하다.

<br/><br/><br/>

## 1. 중요 콜렉션 트레이트

모든 콜렉션은 Iterable trait를 구현하고 있다.  
콜렉션의 모든 원소에 접근할 수 있게 해주는 iterator를 줄 수 있는 콜렉션이다.

- Seq : 배열이나 리스트와 같이 순서가 있는 값의 콜렉션
- Set : 순서가 없는 값의 콜렉션
- Map : (key, value) 쌍의 집합

http://i.stack.imgur.com/bSVyA.png

스칼라 콜렉션 트레이트 혹은 클래스는 컴패니언 오브젝트를 가지고 있다.  
=> new 키워드 사용하지 않고 호출(단일 생성 원칙)

<br/><br/>

## 2. 수정 가능한 콜렉션과 수정 불가능한 콜렉션

둘 다 스칼라에서 제공  
스칼라는 수정 불가능한 콜렉션을 선호!

```
scala.collection.mutable.Map
scala.collection.immutable.Map

scala.collection.Map
PreDef.Map
```

scala.collection 패키지의 컴패니언 오브젝트는 수정 불가능한 콜렉션을 생성  
기본 임포트되는 scala패키지의 Predef 오브젝트는 수정 불가능한 트레이트를 지칭하는 List, Set, Map 타입 별칭을 가지고 있다.  

수정 불가능한 콜렉션은 기존 컬렉션에서 새로운 컬렉션을 만든다.

immutable - http://docs.scala-lang.org/resources/images/collections.immutable.png
mutable - http://i.stack.imgur.com/Dsptl.png

<br/><br/>

## 3. 스퀀스

### 수정 불가능한 시퀀스
IndexedSeq - Vector, Range  
List, Stream, Stack, Queue  

#### Vector
ArrayBuffer의 수정 불가능한 버전.  
빠른 랜덤 액세스가 가능한 인덱스 시퀀스.  
각 노드가 32개까지 자식 노드를 가질 수 있는 트리로 구현.  
100만개는 약32^4이므로 노드 레이어가 4 depth까지 형성, 4번의 뜀으로 access  
(링크드 리스트는 평균 50만)

#### Range 
1,2,3,4 혹은 10,20,30 과 같은 정수 시퀀스  
시작, 끝, 증가 분만 저장하고 있음  
to와 until 메소드로 Range 오브젝트 생성

```
1 to 4 // scala.collection.immutable.Range(1, 2, 3, 4)
5 until 10 // scala.collection.immutable.Range(5, 6, 7, 8, 9)
11 to 19 by 3 // scala.collection.immutable.Range(11, 14, 17)
```

#### List
Go 4절

#### Stream
Go 13절

### 수정 가능한 스퀀스
IndexedSeq - ArrayBuffer  
Stack, Queue, PriorityQueue, LinkedList, DoubleLinkedList

#### ArrayBuffer
가변 길이 배열 (Go back 3장)

#### 기타 등등
우리가 아는 그 자료 구조  
but, LinkedList는 조금 다르다! (Go 5절)

<br/><br/>

## 4. 리스트

Nil 또는 head 원소와 tail 리스트로 구성된 콜렉션

```
val digits = List(4, 2)
digit.head // 4
digit.tail // List(2)
digit.tail.head // ?
digit.tail.tail // ?
```

#### :: 연산자
주어진 head와 tail로 새로운 리스트를 만든다

```
9 :: List(4, 2)
List(9, 4, 2)
9 :: 4 :: 2 :: Nil
9 :: (4 :: (2 :: Nil)) // ::는 오른쪽 결합 연산자
```

#### iterator 보다는 재귀!
리스트의 꼬리는 또 다시 리스트이기 때문에 재귀가 자연스럽게 동작한다.

```
def sum(lst: List[Int]): Int =
  if (lst == Nil) 0 else lst.head + sum(lst.tail)
```

아래는 패턴 매칭을 사용
```
def sum(lst: List[Int]): Int = lst match {
  case Nil => 0
  case h :: t => h + sum(t) // h는 lst.head, t는 lst.tail
}
```

여기서 :: 는 리스트를 머리와 꼬리로 ‘분해’ 한다.

```
List(9, 4, 2).sum // 샤샤샤
```

<br/><br/>

## 5. 수정 가능한 리스트
LinkedList는 elem _레퍼런스_에 대입하여 머리를 수정할 수 있고, next _레퍼런스_에 대입하여 꼬리를 수정할 수 있다. (head, tail에 직접 대입하는 것이 아님)

모든 음의 값을 0으로 변경
```
val lst = scala.collection.mutable.LinkedList(1, -2, 7, -9)
var cur = lst
while (cur != Nil) {
  if (cur.elm < 0) cur.elem = 0
  cur = cur.next
}
```

매 두 번째 원소를 제거
```
while (cur != Nil && cur.next != Nil) {
  cur.next = cur.next.next
  cur = cur.next
}
```

`cur`는 이터레이터로 동작하지만, 실제로는 LinkedList 타입.  
prev 레퍼런스가 있는 DoubleLinkedList도 있음.  
but, 둘 다 2.11.0부터 deprecated됨.  

----
리스트의 노드를 리스트의 마지막 노드로 만들때 next 레퍼런스를 Nill로 할 수 없다. (NPE발생) LinkedList.empty 사용!

<br/><br/>

## 6. 집합
서로 다른 원소의 콜렉션
```
Set(2, 0, 1) + 1 // 아이고 의미 없다.
```

삽입 순서 보존하지 않는다. (왜?? 탐색 속도가 더 빠름!)
```
Set(1, 2, 3, 4, 5, 6) // 5 1 6 2 3 4
```

#### 링크드 해시 집합(LinkedHashSet)
원소가 삽입된 순서 기억. 링크드 리스트를 유지
```
val weekdays  = scala.collection.mutable.LinkedHashSet(“Mo” ,”Tu”, “We”, “Th”, “Fr”)
```

#### 정렬된 집합(SortedSet)
```
scala.collection.immutable.SortedSet(1,2,3,4,5,6)
```
정렬된 집합은 레드-블랙 트리로 구현된다.  \
>> 2.9에 수정 가능한 SortedSet이 없다고 책에 나와있지만, 최신 버전 기준으로는 존재함.


#### 비트 집합(BitSet)
음이 아닌 정수의 집합을 일련의 비트로 구현  
원소 i가 집합에 있으면, i번째 비트의 값이 1이 된다.

```
val digits = Set(1, 7, 2, 9)
digits contains 0 // false
Set(1, 2) subsetOf digits // true
```

union, intersect, diff 메소드는 집합 연산을 수행  
|, &, &~ 로 사용 가능  
++는 합집합  
--는 차집합

<br/><br/>

## 7. 원소들을 추가 혹은 제거하는 연산자

>> 자세한 내용은 교재 163p

coll :+ elem // 콜렉션 뒤에 추가  
elem +: coll // 콜렉션 앞에 추가
```
Vector(1, 2, 3) :+ 5 
1 +: Vector(1, 2, 3)
```

coll + elem  
coll + (e1, e2, ...)  
 
coll - elem  
coll - (e1, e2, ...)

coll ++ coll2  
coll2 ++: coll

coll -- coll2 // 스퀀스는 diff 사용  

elem :: lst // +: 와 같음  
list2 ::: lst // ++: 와 같음

set | set 2 // ++  
set & set2  
set &~ set2 // --  

coll += elem // mutable collection
```
ArrayBuffer(1, 2, 3) += 5
```

- +는 순서없는 콜렉션에 원소 추가
- +: :+ 순서 있는 콜렉션에 원소 추가
- _-_ 원소 제거
- 리스트는 :: ::: 선호
- 집합은 ++ & -- 선호
- immutable은 새로운 콜렉션을 리턴
- mutable은 += ++= -=

<br/><br/>

## 8. 공통 메소드

- Iterable 트레이트의 중요 메소드들. 165p
- Seq 트레이트의 중요 메소드들. 167p

<br/><br/>

## 9. 함수 매핑

#### map
함수를 콜렉션(모든 원소)에 적용한 뒤의 결과를 콜렉션으로 반환

```
val units = List(“Koguryo”, “Baekjae”, “Silla”)
units.map(_.toUpperCase)
// 는 아래와 같음
for ( n <- units) yield n.toUpperCase
```

#### flatMap
함수가 하나의 값이 아닌 콜렉션을 주었을 때, 모든 값을 병합(펼쳐놓음)
```
def ulcase(s: String) = Vector(s.toUpperCase(), s.toLowerCase())
units.map(ulclase) // List(Vector(“KOGURYO”, “Koguryo"), Vector(…)) 
units.flatMap(ulcase) //List(“KOGURYO”, “Koguryo” ...)
```

<br/><br/>

## 10. 리듀싱, 폴딩, 스캐닝

원소들을 이항 함수로 합친다. (map은 단항 함수를 모든 원소에 적용)  

#### reduceLeft/reduceRight
왼쪽 혹은 오른쪽부터 첫 두 원소를 가지고 op 수행 후, 결과를 다시 첫번째 원소로 다음 원소와 다시 op 수행
```
List(1, 7, 2, 9).reduceLeft(_ - _) // ((1 - 7) - 2) - 9 = 1 - 7 - 2 - 9 = -17
List(1, 7, 2, 9).reduceRight(_ - _) // 1 - (7 - (2 - 9)) = 1 - 7 + 2 - 9 = -13
```
https://joelneely.files.wordpress.com/2011/03/foldleftplain.jpg?w=438&h=650  
https://joelneely.files.wordpress.com/2011/03/foldrightplain.jpg?w=438&h=650


#### foldLeft/foldRight
초기 값을 지정 할 수 있는 것이 reduce와 차이  

foldLeft 연산을 `/:`로 foldRight 연산은 `:\`로 사용 가능
```
List(1, 7, 2, 9).foldLeft(0)(_ - _)
(0 /: List(1, 7, 2, 9))(_ - _)
```

#### scanLeft/scanRight
스캐닝 (폴딩 + 맵핑)  
모든 중간 결과의 콜렉션을 얻는다.
```
(1 to 10).scanLeft(0)(_ + _)
Vector(0, 1, 3, 6, 10, .., 45, 55)
```

<br/><br/>

## 11. 지핑

두 개의 콜렉션의 원소들을 병합

```
val prices = List(5, 20, 9)
val quantities = List(10, 2 ,1)
prices zip quantities // List[(Double, Int)] = List((5, 10), (20, 2), (9,1))
(prices zip quantities) map { p => p._1 * p._2 } // List(50, 40, 9)
(prices zip quantities) map { p => p._1 * p._2 } sum
```

하나의 콜렉션이 다른 콜렉션 보다 짧으면, 결과는 더 짧은 콜렉션의 개수만큼 짝을 가진다.

#### zipAll 메소드
더 짧은 리스트에 대해 디폴트를 지정할 수 있게 해준다.
```
List(5, 20, 9).zipAll(List(10,2), 0, 1)
List((5, 10), (20, 2), (9, 1))
```

#### zipWithIndex 메소드
두 번째 요소가 각 원소의 인덱스인 쌍의 리스트를 반환.
```
"Scala" zipWithIndex // Vector((S,0), (c,1), (a,2), (l,3), (a,4))
```

<br/><br/>

## 12. 이터레이터

iterator 메서드로 콜렉션의 이터레이터를 얻을 수 있다.  
완전히 생성하기에 비싼 콜렉션에 유용
- Source.fromFile은 전체 파일을 메모리로 읽는 것이 비효율적일 수 있기 때문에 iterator를 준다.
next와 hasNext 메소드로 원소들을 이터레이트  
```
while (item.hasNext)
  iter.next();
for (elem <- iter)
  elem
```
map, filter, count, sum, 혹은 length와 같은 메소드 호출 후에 이터레이터는 콜렉션의 끝에 위치 (다시 사용 못함)

<br/><br/>

## 13. 스트림

이터레이터는 컬렉션에 대한 ‘lazy’ 대안. 필요할 때 원소를 얻는다.  
그러나 next 호출 시 마다 이터레이터를 _변경_한다.  
스트림은 수정 불가능한 대안을 제시
>> 꼬리가 lazy하게 계산되는 수정 불가능한 리스트.

```
def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
val tenOrMore = numsFrom(10) // Stream(10, ?)
tenOrMore.tail.tail.tail // ?
```
\#::연산자는 리스트의 :: 연산자와 유사하지만, 스트림을 생성한다.

#### 스트림 메소드는 레이지하게 실행된다.
```
val squares = numsFrom(1).map(x => x * x) // Stream(1, ?)
squares.tail // ?
squares.take(5).force // ?
squares.force // ?
```

#### 이터레이터에서 스트림을 생성할 수 있다.
`Source.getLines`는 Iterator[String]을 리턴  
이 이터레이터로 각 행들을 한 번만 방문  
but, 스트림은 방문한 라인을 캐시하여 재방문 할 수 있다.
```
val words = Source.fromFile("/usr/share/dict/words").getLines.toStream
words // Stream(A, ?)
words(5) // Aachen
words // Stream(A, A's, AOL, AOL's, Aachen. ?)
```

<br/><br/>

## 14. 레이지뷰

콜렉션의 view 메소드를 통하여 Stream의 lazy 메소드와 유사한 효과를 얻을 수 있다.
```
(0 until 1000).view // SeqView(...)
val powers = (0 until 1000).view.map(Math.pow(10,_)) // SeqViewM(...)
powers(5) // 100000.0
```
#### 스트림과 차이점
view는 첫 번째 원소조차 계산되지 않는다.  
`powers(5)` 호출하면 `pow(10, 5)`만 계산하고 다른 거듭제곱은 계산되지 않는다.  
어떤 값도 캐시하지 않는다.  
 
큰 콜렉션이 여러 방법으로 변환될 때 유용 (중간 콜렉션을 만들지 않으니까..)

```
(0 to 1000).map(Math.pow(10,_)).map(1/_)
(0 to 1000).view.map(Math.pow(10,_)).map(1/_).force
```

## 15. 자바 콜렉션과 상호 호환
교재 178p  

JavaConversions 오브젝트로 스칼라와 자바 콜렉션 사이의 변환을 제공
```
import scala.collection.JavaConversions._ // import scala.collection.JavaConversions.propertiesAsScalaMap
val props: scala.collection.mutable.Map[String, String] = System.getProperties()
```
변환은 기존 타입을 접근하는 데 타겟 인터페이스를 사용할 수 있게 래퍼를 줌
```
props("com.horstmann.scala") = "impatient"
```
래퍼는 하부의 Properties 오브젝트의 put("com.horstmann.scala", "impatient")를 호출

<br/><br/>

## 16. 쓰레드세이프 콜렉션

여러 쓰레드에서 수정 가능한 콜렉션에 접근할 때, 연산을 동기화 하기 위해 아래 6 트레이트를 제공.

- SynchronizedBuffer
- SynchronizedMap
- SynchronizedPriorityQueue
- SynchronizedQueue
- SynchronizedSet
- SynchronizedStack

```
val scores = new scala.collection.mutable.HasMap[String, Int] with
  scala.collection.mutable.SynchronizedMap[String, Int]
```

모든 메소드를 동기화하기 때문에, java.util.concurrent 패키지의 클래스를 사용하는 것이 더 효율적이다.

<br/><br/>

## 17. 병렬 콜렉션

- 병행(concurrent) - multi thread
- 병렬(parallel) - multi core

모든 원소의 합 : 여러 쓰레드가 병행으로 서로 다른 영역의 합을 계산하고 마지막에 부분 결과들을 더함
```
(0 until 1000).par.sum
for (i <- (0 until 100).par) print(i + " ")
```
par 메소드는 콜렉션의 병렬 구현을 생성.  
par 메소드로 리턴되는 병렬 콜렉션은 ParSeq, ParSet, ParMap 트레이트를 확장하는 타입  
이들 모두 ParIterable의 서브타입. Iterable의 서브타입이 아님!!  
병렬 콜렉션을 순차 콜렉션으로 변환하기 위해서 `seq` 메소드 사용.

