package ProgrammingInScala.ch12

/**
  * Rectangular 트래이트를 믹스인하여 바로 width, left같은 기하학적 속성을 조회할 수 있다
  * @param topLeft
  * @param bottomRight
  */
class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
  //etc
}
