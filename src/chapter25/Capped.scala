package chapter25

import scala.collection._

class Capped[A] private (
                        val capacity: Int,
                        val length: Int,
                        offset: Int,
                        elems: Array[Any]
                        )
extends immutable.Iterable[A] {
  self => def this(capacity: Int) = this(capacity, length = 0, offset = 0, elems = Array.ofDim(capacity))

  def appended[B >: A](elem: B): Capped[B] = {
    val newElems = Array.ofDim[Any](capacity)
    Array.copy(elems, 0, newElems, 0, capacity)
    val (newOffset, newLength) =
      if (length == capacity) {
        newElems(offset) = elem
        ((offset + 1) % capacity, length)
      } else {
        newElems(length) = elem
        (offset, length + 1)
      }
    new Capped[B](capacity, newLength, newOffset, newElems)
  }
  @inline def +: [B >: A](elem:B): Capped[B] = appended(elem)

  def apply(i: Int): A =
    elems((i + offset) % capacity).asInstanceOf[A]

  def iterator: Iterator[A] = new AbstractIterator[A] {
    private var current = 0
    def hasNext = current < self.length
    def next (): A = {
      val elem = self(current)
      current += 1
      elem
    }
  }

  override def className: String = "Capped"
}
