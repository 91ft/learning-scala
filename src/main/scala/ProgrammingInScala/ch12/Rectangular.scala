package ProgrammingInScala.ch12

/**
  * Created by Harley on 2016. 4. 22..
  */
trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // etc..
}
