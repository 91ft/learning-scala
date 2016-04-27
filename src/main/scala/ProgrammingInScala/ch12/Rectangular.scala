package ProgrammingInScala.ch12

/**
  * 직사각형을 표현하는 클래스는 아래와 유사한 정의가 필요할 것이다.
  * 풍부한 트레이트 정의
  * 믹스인하여 사용하면 코드 반복을 줄일 수 있다
  */
trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // 여러 기하 관련 메소드..
}
