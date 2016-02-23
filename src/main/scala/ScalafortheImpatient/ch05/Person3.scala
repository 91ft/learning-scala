package ScalafortheImpatient.ch05

/**
  * Created by Harley on 2016. 2. 16..
  */
class Person3 {
  var publicAge = 0 //public getter,setter
  private var privateAge = 0 //private getter,setter
  val finalAge = 0 //only public getter
  private[this] var noGetterSetterAge = 0 //no getter,setter
}
