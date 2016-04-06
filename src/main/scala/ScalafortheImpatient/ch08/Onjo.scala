package ScalafortheImpatient.ch08

/**
  * Created by Harley on 2016. 4. 6..
  *
  * id를 단순히 생성자에서 받도록 함.
  */
class Onjo(name: String, override val id:Int) extends Person(name){

}
