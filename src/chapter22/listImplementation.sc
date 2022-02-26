abstract class Fruit
class Apple extends Fruit
class Orange extends Fruit

val apples = new Apple :: Nil
val fruits = new Orange :: apples

fruits
apples
fruits.tail

::[Int](1, Nil)

scala.collection.immutable.List

class A {
  def +(xs: List[A]) = {
    println("+ oof A")
  }
  def ::(xs: List[A]) = {
    println(":: of A")
  }
}

val l = List[A]()
new A :: l
new A + l
(new A()).::(l)
::(new A, l)



def incremental(xs: List[Int]) = {
  var result = List[Int]()
  for(x <- xs) {
    result = result ::: List(x + 1)
  }
  result
}

incremental(List(1, 2, 3, 4))

import scala.collection.mutable.ListBuffer

def incremental(xs: List[Int]) = {
  val result = new ListBuffer[Int]
  for(x <- xs) {
    result.append(x + 1)
  }
  result.toList
}

incremental(List(1, 2, 3, 4))

::[Int](1, List(1))