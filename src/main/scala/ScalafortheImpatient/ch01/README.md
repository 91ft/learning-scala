# Chapter1. 기본기

## 스칼라 설치
```
$ brew update
$ brew install scala
```

## 스칼라 인터프리터
Read-Eval-Print-Loop라는 뜻에서 REPL(발음:레플)이라고 부름

## JVM언어
http://zeroturnaround.com/rebellabs/the-adventurous-developers-guide-to-jvm-languages-java-scala-groovy-fantom-clojure-ceylon-kotlin-xtend/

## 패러다임
- 절차적 프로그래밍 : 순서와 제어. 일직선으로 나아가는 방식이라면,
- 객체 지향 프로그래밍 : 현실 세계의 모델링을 추구. 멤버와 메소드로 구분. ex) 고양이. 색깔, 크기, 소리를 내다, 먹다
- 함수형 프로그래밍 : 함수자체도 값으로 취급. 리스트 처리에 장점. 재귀호출이 탁월 함. 나선형으로 진행되는 방식이다.
- 스칼라는 객체지향, 함수형의 다중패러다임 언어 임.

## 함수형 프로그래밍 
- https://ko.wikipedia.org/wiki/%ED%95%A8%EC%88%98%ED%98%95_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D
- 함수형 프로그래밍 언어에서 자주 등장하는 단어
    -  순수한 함수 (pure function)
    -  부작용 없는.. (side-effect)
    -  스레드 안전 (thread safe) : synchronized를 사용하지 않아도 됨. 병렬처리 가능.
    -  일급 객체 (First-class citizen)

## 일급객체의 조건 
- https://ko.wikipedia.org/wiki/%EC%9D%BC%EA%B8%89_%EA%B0%9D%EC%B2%B4
- 변수나 데이터 구조안에 담을 수 있다.
- 파라미터로 전달 할 수 있다.
- 반환값(return value)으로 사용할 수 있다.
- 할당에 사용된 이름과 관계없이 고유한 구별이 가능하다.
- 동적으로 프로퍼티 할당이 가능하다.

## function vs method
- method : class안에 들어있는 것. def로 정의 됨
- function : 객체 안에 포함되어 있지 않은 것??

## 값과 변수 선언하기
- val : immutable. getter만 있음. 할당 불가능
- var : mutable. getter/setter모두 있음. value
- 세미콜론 안 써도 됨
```
    var = variable
    val = variable + final (or value)
```

## 타입
- 모든 타입이 클래스다. primitive type, class type 구분이 없음.
- 다양한 method 제공한다. 알파벳 뿐만 아니라 기호만으로도 함수명 지정가능 (ex. BigInt의 /% )

## Scala Docs
- ex) StringOps Docs : http://www.scala-lang.org/api/current/#package

## Closure : lexically scoped code. 하나의 스콥을 생성해준다는 개념
- 클로저는 자신의 범위(Scope) 밖에 있는 변수들에 접근할 수 있는 함수를 의미한다
```
function outerFn() {
    var count=1;
    return function (cnt) {
        count += cnt;
        console.log(count);
    }
}
var func = outerFn();
func(10); // 결과 값 11
func(10); // 결과 값 21
```
- 위 코드에서 func=outerFn()이 Closure가 됨.
- count는 function (cnt)외부에 있는 변수로써 func에 의해 참조되고 있음.
- func가 살아있는 한 count는 GC에 의해 사라지지 않음.
- func = null;로 명시적으로 참조를 없애야 count는 GC대상이 됨.

## 함수 리터럴
- 다른 구문의 식 안에서 함수를 사용하면, 이것은 함수 리터럴(function literal)이다.
- 함수 리터럴은 함수이름을 명시 하지 않는 것을 제외하고는 함수의 일반적인 정의 방법과 모양이 동일하다.

## 참고. 기초 문서
- 트위터에서 스칼라에 입문하는 개발자를 위해 만든 가이드 (한글)
    - https://twitter.github.io/scala_school/ko/basics.html
- Community-driven documentation for Scala (한글)
    - http://docs.scala-lang.org/ko/tutorials/scala-for-java-programmers.html
