val numbers = List(1, 2, 3)
val tuples = List(
  List(1, 2),
  List(2, 3),
  List(3, 4)
)

val numbersUsingCons = 1 :: 2 :: 3 :: Nil

print(numbers == numbersUsingCons)

println(numbers.head)
println(numbers.tail)
println(numbers.isEmpty)

//val List(one, two, three) = numbers
//println(one, two, three)

//val one :: two :: three :: Nil = numbers
//println(one, two, three)

val one :: rest = numbers
println(one, rest)

List(1, 2) ::: List(3, 4)

List(1, 2, 3, 4, 5).reverse

numbers.take(2)
numbers.drop(1)
numbers.splitAt(1)

numbers.apply(0)
numbers(0)

numbers.indices

val twoDimension = List(
  List(1, 2),
  List(3, 4, 5),
  List(6, 7, 8, 9)
)

twoDimension.flatten

val threeDimension = List(
  List(
    List(1, List(3, 4))
  ),
  List(
    List(2, 3),
    List(4, 5)
  )
)
threeDimension.flatten

val list1 = List(1, 2, 3)
val list2 = List("a", "b", "c")

val zippedList = list1.zip(list2)
zippedList

val (a, b) = zippedList.unzip
println(a)
println(b)


println(zippedList.toString)
println(zippedList.mkString("[", "|", "]"))

val chars = List('a', 'b', 'c', 'd')
val charArray = chars.toArray
println(charArray)
println(charArray.toList)

val integerArray = new Array[Int](10)
val integerList = List(1, 2, 3)

integerList.copyToArray(integerArray, 2)
integerArray


val iter = integerList.iterator

iter.next

integerList map ((x) => x * 2)
integerList map (_ * 2)

integerList flatMap (x => List(x * 2, x * 3))

List.range(1, 5).flatMap(
  i => List.range(1, i) map (j => (i, j))
)

var sum = 0
List(1, 2, 3, 4, 5).foreach(
  x => sum += x
)

sum


List(-1, 0, 1, 2).filter(
  _ > 0
)

List(-1, 0, 1, 2).partition(_ > 0)

List(1, 2, 3).find(_ > 0)

List(1, 2, 3).find(_ < 0)

List(1, 2, 3, 4, 5).takeWhile(_ < 3)
List(1, 2, 3, 4, 5).takeWhile(_ > 2)

List(1, 2, 3, 4, 5).dropWhile(_ < 3)
List(1, 2, 3, 4, 5).dropWhile(_ > 2)

List(1, 2, 3, 4, 5).span(_ > 3)

List(1, 2, 3, 4, 5) forall (_ < 10)
List(1, 2, 3, 4, 5) exists (_ == 0)

List(1, 2, 3, 4, 5).foldLeft(0)(_ + _)
List("This", "is", "scala", "language").foldLeft("")(_ + " " + _)

val stringList = List("This", "is", "scala", "language")
stringList.tail.foldLeft(stringList.head)(_ + " " + _)

val massList = List(3, 1, 4, 2, 5)
massList.sortWith(_ > _)

val massStrings = List("a", "zc", "def", "gh")
massStrings.sortWith(_.length > _.length)


List.apply(1, 2, 3)
List.range(0, 3)

List.range(0, 6, 2)

List.fill(3)('a')

List.fill(2, 2)("two")

List.tabulate(4)(n => n * n)

List.tabulate(2, 3)(_ * _)

List.concat(List(1), List(2), List(3, 4))
List.concat(List(), List(1, 2), List("a"))


List(1, 2, 3).zip(List(10, 20)).map{ case (x, y) => x * y }

List(1, 2, 3).lazyZip(List(4, 5)).map(_ * _)

