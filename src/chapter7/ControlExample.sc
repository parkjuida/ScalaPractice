def ifStatementFunction(input: String): String = {
  var name = "default"
  if (!input.isEmpty) name = input
  name
}

println(ifStatementFunction(""))
println(ifStatementFunction("this is input"))

def ifStatementFunction2(input: String):String = {
  val name = if(input.isEmpty) "default" else input
  name
}

println(ifStatementFunction2(""))
println(ifStatementFunction2("this is input"))

// while
var counter = 0
while(counter < 10) {
  counter += 1
}
println(counter)

do {
  counter += 1
} while(counter < 20)
println(counter)

def returnUnitFunction() = println("unit created")
var a = returnUnitFunction()
a
a = 10


// for expression
val numbers = List(1, 2, 3, 4, 5)

for(number <- numbers if number != 2 if number != 3) {
  println(number)
}

// 중첩 포문
val numberLists = List(List(2, 4, 6), List(3, 6), List(4, 8, 12, 16))

for(numberList <- numberLists
    if(numberList.length > 3);
    number <- numberList
    if(number > 10)) {
  println(number)
}

// 중첩 포문
for{numberList <- numberLists
    if(numberList.length > 3)
    number <- numberList
    fiveTimesBig = number * 5
    if(fiveTimesBig > 10)} {
  println(fiveTimesBig)
}

val numberLists = List(List(2, 4, 6), List(3, 6), List(4, 8, 12, 16))

val lists = for{
  numberList <- numberLists
  if(numberList.length > 3)
  number <- numberList
  fiveTimesBig = number * 5
  if(fiveTimesBig > 10)
} yield fiveTimesBig

lists

// 예외
def errorFunction(n: Int): Int = {
  try {
    if(n > 10) throw new IllegalArgumentException
    if(n < 0 ) throw new RuntimeException
    n * 10
  } catch {
    case ex: IllegalArgumentException => println("IllegalArgument"); 0
    case ex: RuntimeException => println(" RuntimeException"); 0
  }
}

errorFunction(11)
errorFunction(-1)
errorFunction(10)

// 예외 값 반환
def f(): Int = try return 1 finally return 2
def g(): Int = try 1 finally 2
println(f())
println(g())

def switch(n: Int) = {
  n match {
    case 3 => println("Three")
    case 2 => println("Two")
    case _ => println("default")
  }
}

switch(3)
switch(2)
switch(-1)

val n = 10
val nToString = n match {
  case 10 => "Ten"
}
nToString