
object StringMatcher {
  private def getStrings() = List(
    "Ironman",
    "Kafka",
    "Korean man",
    "Son Heung min",
    "Korea drama"
  )

  def stringsEnding(query: String) =
    for(string <- getStrings; if string.endsWith(query))
      yield string

  def stringsContaining(query: String) =
    for(string <- getStrings; if string.contains(query))
      yield string
}

val endsWith = StringMatcher.stringsEnding("man")
endsWith
val containing = StringMatcher.stringsContaining("ma")
containing

// 함숫 값 이용 중복 제거
object StringMatcher {
  private def getStrings() = List(
    "Ironman",
    "Kafka",
    "Korean man",
    "Son Heung min",
    "Korea drama"
  )

  def stringsMatching(query: String,
                      matcher: (String, String) => Boolean) = {
    for (string <- getStrings; if matcher(string, query))
      yield string
  }

  def stringsEnding(query: String) =
    stringsMatching(query, _.endsWith(_))


  def stringsContaining(query: String) =
    stringsMatching(query, _.contains(_))
}

val endsWith = StringMatcher.stringsEnding("man")
endsWith
val containing = StringMatcher.stringsContaining("ma")
containing

// query 리팩토링
object StringMatcher {
  private def getStrings() = List(
    "Ironman",
    "Kafka",
    "Korean man",
    "Son Heung min",
    "Korea drama"
  )

  def stringsMatching(matcher: (String) => Boolean) = {
    for (string <- getStrings; if matcher(string))
      yield string
  }

  def stringsEnding(query: String) =
    stringsMatching(_.endsWith(query))


  def stringsContaining(query: String) =
    stringsMatching(_.contains(query))
}

val endsWith = StringMatcher.stringsEnding("man")
endsWith
val containing = StringMatcher.stringsContaining("ma")
containing

//
def containsPos(nums: List[Int]): Boolean = {
  var exists = false
  for(num <- nums)
    if(num > 0)
      exists = true
  exists
}

println(containsPos(List(0, -1)))
println(containsPos(List(1, 2, 3)))

def containsPos(nums: List[Int]) = nums.exists(_ > 0)

println(containsPos(List(0, -1)))
println(containsPos(List(1, 2, 3)))

// 커링
def plainSum(x: Int, y: Int): Int = x + y

def curriedSum(x: Int)(y: Int): Int = x + y

println(plainSum(1, 2))
println(curriedSum(1)(2))

def curriedSum(x: Int) = (y: Int) =>  x + y

println(curriedSum(1)(2))
val plusOne = curriedSum(1)
println(plusOne(2))

// 커링 함수 재활용
def curriedSum(x: Int)(y: Int) = x + y
val plusOne = curriedSum(1)_
println(plusOne(2))

//def transaction(config: Config)(op: Connector => Unit) = {
//  val connector = new Connector(config)
//  try {
//    op(connector)
//  } finally {
//    connector.close()
//  }
//}
//
//transaction(new Config("config.yml")) {
//  connector => connector.doSomethiong()
//}
//
//transaction(
//  new Config("config.yml"),
//  connector => connector.doSomethiong()
//)
println { "Hello, World!"}

def myAssertion(predicate: () => Boolean): Unit = {
  if(!predicate())
    throw new AssertionError
}

myAssertion(() => 3 > 0)

// 이름에 의한 호출
def myAssertion(predicate: => Boolean): Unit = {
  if(!predicate)
    throw new AssertionError
}

myAssertion(3 > 0)