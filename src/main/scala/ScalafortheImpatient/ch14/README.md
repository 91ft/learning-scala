# Chapter 14. 패턴 매칭과 케이스 클래스

> 주요 내용
> 스칼라에는 자바의 switch 문과 비슷하지만, 더 강력한 match - case 가 있다.
> 패턴 매칭과 동작하는데 최적화된 케이스 클래스가 있다.

## match

자바의 switch - case
```
String result = null;
switch (num) {
    case 1 : result = "one"; break;
    case 2 : result = "two"; break;
    default : result = "other";
}
```
스칼라의 match - case
```
val result = num match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
}
```
