package ch5

/**
  * Created by Harley on 2016. 2. 16..
  */
class Person2 {
  private var privateAge = 0

  def age = privateAge
  def age_=(newValue: Int): Unit = {
    if (newValue > privateAge) privateAge = newValue; //젊어질 수 없음
  }
}
