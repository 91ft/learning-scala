package ScalafortheImpatient.ch05

/**
  * Created by Harley on 2016. 2. 16..
  */
class Person {
  var age = 0 //공개 getter, setter가 생긴다.

  private var weight = 0 //비공개 getter, setter가 생긴다.

  private[this] var value = 0 //오브젝트-비공개 필드. 아예 getter/setter생성되지 않음
}
