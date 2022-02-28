for (x <- List(1, 2, 3)) yield x * 10

List(1, 2, 3).map(_ * 10)

for {
  x <- List(-2, -1, 0, 1, 2)
  if x >= 0
} yield x * 10

for (  x <- List(-2, -1, 0, 1, 2) withFilter (x => x >= 0)) yield x * 10

List(-2, -1, 0, 1, 2).withFilter(_ >= 0).map(_ * 10)


val expr_1: List[List[Int]] = List(List(-2, -1), List(0, 1), List(0, 20), List(1, 2))
for {
  x <- expr_1
  y <- x
  if y != 0
}
  yield y

expr_1.flatMap(x => x withFilter (x => x != 0) map (x => x))


val tuples = List((1, 2), (2, 3), (3, 4))

for((left, right) <- tuples) yield left + right
tuples.map{ case (left, right) => left + right }


val numbers = List(1, 2, 3, 4, 5)

numbers.foreach(println)
val groupedNumbers = numbers.grouped(2)
groupedNumbers.next()
groupedNumbers.next()
groupedNumbers.next()

val slidingNumbers = numbers.sliding(3)
slidingNumbers.next()
slidingNumbers.next()
slidingNumbers.next()

val numbersBuffer = scala.collection.mutable.ListBuffer(1, 2, 3, 4, 5)

numbersBuffer.mapInPlace(_ * 10)

val numberSet = Set(1, 2, 3, 4, 5)
numberSet(1)
numberSet(10)


Set(1) + 2
Set(1) ++ Set(2, 3)

Set(1, 2, 3) -- Set(0, 1)

Set(1, 2) | Set(2, 3)
Set(1, 2) union Set(2, 3)

Set(1, 2) & Set(2, 3)
Set(1, 2) intersect Set(2, 3)

Set(1, 2) &~ Set(2, 3)
Set(1, 2) diff Set(2, 3)

val numberMap = Map("a" -> 1, "b" -> 2, "c" -> 3)

numberMap("a")
numberMap get "b"

numberMap + ("d" -> 4)
numberMap.updatedWith("a")(x => Option[Int](x.get * 10))

import java.util.concurrent.ConcurrentHashMap

import scala.collection.concurrent.TrieMap
import scala.collection.immutable.{BitSet, Queue}
import scala.collection.{ArrayOps, mutable}
import scala.collection.mutable.{ArrayBuffer, ListBuffer, Map}

def f(x: String) = {
  println("Time...")
  Thread.sleep(100)
  x.reverse
}

val cache = Map[String, String]();

def cachedF(s: String) = cache.getOrElseUpdate(s, f(s))


val str = 1 #:: 2 #:: 3 #:: LazyList.empty

def fibFrom(a: Int, b: Int): LazyList[Int] =
  a #:: fibFrom(a, a + b)

val fibs = fibFrom(1, 1).take(7)


val vec = scala.collection.immutable.Vector.empty
val vec2 = vec :+ 1 :+ 2
vec2

val immutableQueue = Queue[Int]()
val lengthOneQueue = immutableQueue enqueue 1
val (element, emptyQueue) = lengthOneQueue.dequeue


1 to 5
1 to 5 by 2

1 until 5
for(i <- 1 to 5) yield i
for(i <- 1 to 5 by 2) yield i
for(i <- 1 until 5) yield i


val bits = BitSet.empty
val writtenBits = bits + 3 + 3 + 4
writtenBits

val listBuffer =  new ListBuffer[Int]
listBuffer += 1
listBuffer += 2
listBuffer.toList

val stringBuilder = new StringBuilder
stringBuilder += 'a'
stringBuilder ++= "bcde"

stringBuilder.toString


val mutableQueue = new scala.collection.mutable.Queue[Int]()
mutableQueue += 1
mutableQueue += 2
mutableQueue ++= List(3, 4)
mutableQueue.dequeue

val mutableStack = new mutable.Stack[Int]();
mutableStack.push(1)
mutableStack.push(2)

mutableStack.pop()
mutableStack.pop()

val concurrentMap = new ConcurrentHashMap[String, Int]()
val trieMap = new TrieMap[String, Int]

val integerArray = Array(1, 2, 3, 4)
integerArray map (_ * 10)

val integerArraySeq: mutable.ArraySeq[Int] = integerArray

integerArray == integerArraySeq.toArray

val integerArrayOps: ArrayOps[Int] = integerArray

integerArray.reverse
integerArrayOps.reverse
intArrayOps(integerArray).reverse

//def evenElems[T](xs: Vector[T]): Array[T] = {
//  val arr = new Array[T]((xs.length + 1) / 2)
//  for (i <- 0 until xs.length by 2)
//    arr(i / 2) = xs(i)
//  arr
//}

//evenElems[Int](Vector[Int](1, 2, 3))

import scala.reflect.ClassTag
def evenElemsWithClassTag[T: ClassTag](xs: Vector[T]): Array[T] = {
  val arr = new Array[T]((xs.length + 1) / 2)
  for (i <- 0 until xs.length by 2)
    arr(i / 2) = xs(i)
  arr
}

evenElemsWithClassTag(Vector(1, 2, 3, 4, 5))

List(1, 2, 3) == Vector(1, 2, 3)
Set(1, 2, 3) == List(1, 2, 3)

val v = Vector(1 to 10: _*)
v map (_ + 1) map (_ * 2)


(v.view map (_ + 1) map (_ * 2)).to(Vector)

val vv = v.view
val incresedVv = vv map (_ + 1)
val twicedVv = incresedVv map (_ * 2)
twicedVv.toVector

val stringList = List("Apple", "Banana", "Can")
val it = stringList.iterator
while(it.hasNext) {
  println(it.next())
}

stringList.map(_.length).foreach(println)

val it2 = stringList.iterator
it2.foreach(println)
it2.hasNext

def skipEmptyWords(it: Iterator[String]): String = {
  while (it.next.isEmpty) {}
  it.next
}

skipEmptyWords(stringList.iterator)


List(1, 2, 3)
Vector(1, 2, 3)
Map("a" -> 1, "b" -> 2)

List.fill(2)(1)
List.tabulate(5)(x => x + 1)