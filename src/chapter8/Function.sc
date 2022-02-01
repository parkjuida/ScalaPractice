import scala.collection.immutable.HashMap

class ClassExample {
  val postFix = "ClassExample`s method"

  def printFunction(s: String): Unit = {
    println(getModifiedString(s))
  }

  private def getModifiedString(str: String): String = {
    s"$postFix: $str"
  }
}

val classExample = new ClassExample()
classExample.printFunction("do print")

val functionLiteral = (x: Int) => x + 1
functionLiteral(2)

val list = List(1, 2, 3, 4, 5)
list.foreach(println)
list.foreach(x => print(s"$x "))
list.filter(x => x > 3)
list.filter(_ > 3)

val twoArgFunction = (_: Int) + (_: Int)
println(twoArgFunction(1, 2))

val someNumbers = List(1, 2, 3, 4, 5)
someNumbers.foreach(print)

def sum(a: Int, b: Int, c: Int) = a + b + c
sum(1, 2, 3)

val sumTen = sum(5, 5, _: Int)
sumTen(10)

val allReplaced = sum _
allReplaced(1, 2, 3)

//def outer() = {
//  def inner(str: String) = print(s"I'm $str")
//  inner
//}

//val getInnerFunction = outer
//getInnerFunction("inner")

var more = 10
val freeFunction = (x: Int) => x + more
freeFunction(10)

more = 10000
freeFunction(10)

def makeCloser(arg: Int) = {
  (x: Int) => x + arg
}

val plusOne = makeCloser(1)
val plusTen = makeCloser(10)
plusOne(10)
plusTen(10)


//반복파라미터
def echo(args: String*) = {
  for(arg <- args) {
    print(s"$arg ")
  }
}

echo("가")
echo("A", "B")

val list = List("A", "B", "C")
echo(list: _*)

def createPerson(name: String = "park", age: Int = 10) = {
  s"$name $age"
}

println(createPerson())
println(createPerson(age = 30))

// 꼬리재귀
//def approximate(guess: Double): Double =
//  if (isGoodEnough(guess)) guess
//  else approximate(improve(guess))
//
//def approximateLoop(initialGuess: Double): Double = {
//  var guess = initialGuess
//  while (!isGoodEnough(guess)) {
//    guess = improve(guess)
//  guess
//  }
//}

def boom(x: Int): Int = {
  if(x == 0) throw new Exception("boom!")
  else boom(x - 1)
}

boom(3)