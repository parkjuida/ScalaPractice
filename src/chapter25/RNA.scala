package chapter25

import collection.mutable
import collection.immutable.{IndexedSeq, IndexedSeqOps}

abstract class Base

case object A extends Base
case object U extends Base
case object G extends Base
case object C extends Base

object Base {
  val fromInt: Int => Base = Array(A, U, G, C)
  val toInt: Base => Int = Map(A -> 0, U -> 1, G -> 2, C -> 3)
}

final class RNA1 private(val groups: Array[Int],
                        val length: Int)
extends IndexedSeq[Base] with IndexedSeqOps[Base, IndexedSeq, RNA1] {
  import RNA1._
  def apply(idx: Int) = {
    if (idx < 0 || idx >= length) {+
      throw new IndexOutOfBoundsException
    }
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }

  override protected[this] def className: String = "RNA1"
  override protected def fromSpecific(source: IterableOnce[Base]): RNA1 =
    fromSeq(source.iterator.toSeq)
  override protected def newSpecificBuilder:
      mutable.Builder[Base, RNA1] =
    iterableFactory.newBuilder[Base].mapResult(fromSeq)
  override def empty: RNA1 = fromSeq(Seq.empty)
}

object RNA1 {
  private val S = 2
  private val N = 32 / S
  private val M = (1 << S) - 1

  def fromSeq(buf: collection.Seq[Base]): RNA1 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- buf.indices)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA1(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)
}
