package ProgrammingInScala.ch10
import Element.elem
/**
  * Created by Harley on 2016. 4. 19..
  */
object Element {
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElement(line)
}

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int =
    if (height == 0) 0 else contents(0).length

  def above(that: Element): Element =
    elem(this.contents ++ that.contents)

  def beside(that: Element): Element =
    elem(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + ":" + line2
    )
  override def toString = contents mkString "\n"
}

class ArrayElement(val contents: Array[String]) extends Element

class UniformElement( ch: Char,
                      override val width: Int,
                      override val height: Int
                    ) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}