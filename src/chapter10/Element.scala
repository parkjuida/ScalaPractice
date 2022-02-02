package chapter10

import chapter10.Element.elem

abstract class Element {
  def contents: Array[String]
  def height = contents.length
  def width = if(height == 0) 0 else contents(0).length

  def above(other: Element): Element = {
    elem(this.contents ++ other.contents)
  }

  def beside(other: Element): Element = {
    elem(
      for((line1, line2) <- this.contents zip other.contents)
        yield line1 + line2
    )
  }

  override def toString: String = contents.mkString("\n")
}

object Element {
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(contents: String): Element =
    new LineElement(contents)

  private class ArrayElement(val contents: Array[String]) extends Element {
  }

  private class LineElement(val s: String) extends Element {
    override def contents: Array[String] = Array(s)
    override def width = s.length
    override def height = 1
  }

}