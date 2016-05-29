/**
  * Created by hyeyoungkang on 2016. 5. 25..
  */
import scala.math._
// fun 은 ceil이라는 함수를 저장하는 변
val num: Double = 3.14

// 소수점 이하 모두 올림수
val fun = ceil _   // 여기 _ 의 쓰임!

/*
기술적으로 _는 ceil 메소드를 함수로 바꾼다.
스칼라에서는 메소드는 조작할수 없고, 오직 함수만 가능하다.

math객체의 메소드 ceil을 함수로 바꿔서 저장.

*/


fun(num)
/*

(Double) => Double
fun의 타입은 Double을 받아서 Double를 리턴하는 함수

일반적인 함수 호출 방법,
유일한 차이점은 fun이 고정된 함수가 이나라 함수를 저장하고 있는 변수라는 점.
*/
Array(3.14, 3.23, 2.0).map(fun)
sqrt(2)
sqrt(2.0)
//map메소드는 함수를 받아서 배열에 있는 모든 값에 적용하고 함수 값들로된 배열을 리턴한다. ?

def valueAtOneQuarter(f: Double => Double) = f(0.25)
//이 고차 함수는 함수를 생성할수도 있다.
def multiplyBy(factor:Double) = (x:Double) => factor * x
//multiplayBy함수는 Double타입의 인자를 갖고. (Double)=>Double를 리턴한다.
val mulFun = multiplyBy(3.0)


mulFun(20.0)

//multiplyBy함수는 3을 인자로 받아서  3*x를 반환하는 함수를 리턴
//
//12.4 인자 추론
valueAtOneQuarter((x:Double) => x*3)

valueAtOneQuarter((x) => x*3)
valueAtOneQuarter( x => x*3 )

//인자가 오른쪽ㅇ 한번만 나오면 이를 밑줄로 바꿀수있다.
valueAtOneQuarter( 3* _)

//  단축은 인자 타입을 미리 알때만 가능하다.!!
//val zoo = 3 * _
val zooFun:(Double) => (Double) = 3* _



