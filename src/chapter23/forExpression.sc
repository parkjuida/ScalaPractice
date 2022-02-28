import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.collection.immutable.{BitSet, Queue}

case class Person(name: String, isMale: Boolean, children: Person*)

val park = Person("Park", false)
val lee = Person("Lee", true)
val cha = Person("Cha", false, park, lee)
val persons = List(cha, lee, park)

for(p <- persons; n = p.name; if n startsWith "P") yield p

for(p <- persons;
    n = p.name;
    if n endsWith "e")
  yield p


case class Book(
               title: String,
               authors: String*
               )

val library = List(
  new Book(
    "Structure and Interpretation of Computer Programs",
    "Abelson, Harold", "Sussman, Gerald J."
  ),
  new Book(
    "Principles of Compiler Design",
    "Aho, Alfred", "Ullman, Jeffrey"
  ),
  new Book(
    "Programming in Modula-2",
    "Wirth, Niklaus"
  ),
  new Book(
    "Elements of ML Programming",
    "Ullman, Jeffrey"
  ),
  new Book(
    "The Java Language Specification", "Gosling, James",
    "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
  )
)

for (b <- library; a <- b.authors; if a startsWith "Gosling")
  yield b.title

for {
  b <- library
  if b.title contains "Program"
}
  yield b.title

val result = for {
  b1 <- library
  b2 <- library
  a1 <- b1.authors
  a2 <- b2.authors
  if b1 != b2
  if a1 == a2
}
  yield a1


def removeDuplicate(xs: List[String]): List[String] = {
  if (xs.isEmpty) Nil
  else xs.head :: removeDuplicate(
    xs.tail filter (x => x != xs.head)
  )
}

removeDuplicate(result)


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

import scala.collection.mutable.Map

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

val arrayBuffer =