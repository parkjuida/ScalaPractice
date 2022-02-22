import scala.collection.immutable.TreeSet

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

val integerArray = new Array[Int](5)
integerArray

val integerArray2 = Array(1, 2, 3, 4, 5)
integerArray2

// List(5, 4, 3, 2, 1)

val list = new ListBuffer[Int]
list.append(1) // list += 1
list.append(2)
list.append(3)
list.prepend(0)
list.prepend(-1)
list.toList


val list1 = new ListBuffer[Int]
list1 += 1
list1 += 2
list1 += 3
0 +=: list1
-1 +=: list1
list1.toList

val arrayBuffer = new ArrayBuffer[Int]
arrayBuffer += 1
arrayBuffer += 2
arrayBuffer

"abc".exists(_ == 'a')

val words = Array("Korea", "USA", "KOREA", "usa", "korea")
val set = scala.collection.mutable.Set[String]()

for(word <- words) {
  set += word.toLowerCase()
}

set

val immutableSet = Set(1, 2, 3, 4)
immutableSet + 5
immutableSet - 4
immutableSet ++ List(3, 4, 5, 6)
immutableSet -- List(0, 1, 2)
immutableSet & Set(2, 3)

val mutableSet = scala.collection.mutable.Set.empty[Int]
mutableSet += 1
mutableSet ++= List(2, 3, 4)
mutableSet -= 1
mutableSet --= List(2, 3)


val mutableMap = scala.collection.mutable.Map[String, Int]()

mutableMap("Apple") = 1
mutableMap("Banana") = 2

mutableMap

mutableMap("Apple")
//
//val numsMap = Map("a" -> 1, "b" -> 2)
//numsMap + ("c" -> 3)
//numsMap - "a"
//numsMap ++ List("c" -> 3, "d" -> 4)
//numsMap -- List("a" -> 1, "b" -> 2)

import scala.collection.immutable.{TreeSet, TreeMap}

val treeSet = TreeSet(3, 2, 4, -1, -3)
treeSet

val treeMap = TreeMap(
  "d" -> 4,
  "b" -> 100,
  "a" -> 1
)

treeMap

var varImmutableSet = Set(1, 2)
varImmutableSet += 3

//val valImmutableSet = Set(1, 2)
//
//valImmutableSet += 3

import scala.collection.immutable.TreeSet
//
//val massSet = List(-3, 10, -7, 0, 2)
//
////massSet.to(TreeSet)
//massSet to TreeSet

//val colors = List[String]("blue", "yellow", "red", "green")
//import scala.collection.immutable.TreeSet
//colors to TreeSet


//val treeSet = TreeSet(8, -1, 4, -10)
//treeSet.toList
//treeSet.toArray
//
//var a = treeSet.to(scala.collection.mutable.TreeSet)


val tuple = ("a", 1)
tuple

tuple._1
tuple._2

val (a, one) = tuple
print(a, one)