
println("""hihi
      abcdef
     test
    """
)

println(
  """
    |abcd
    |sdflkj
    |""".stripMargin)

// 심볼리터럴
print('age)
println('age)

val name = "testUser"
val age = 30
println(s"Name: $name, Age: $age, Born in ${2022 - age}")
// 출력 Name: testUser, Age: 30, Born in 1992

println(s"\\ ")    // s는 이스케이프 문자 적용   \ " "
//println(raw"\\ \'a \"")  // raw는 이스케이프 문자 출력 \\ \' \"

val temperature = 10.2
println(f"${math.Pi}%.5f, ${temperature}%20.2f") // f는 printf 형태가 적용되어 출력

1.+(2)

val number = 10
number

//연산자
class CalculateSymbol {
  var String = "Prefix"
  def concat(s: String): String = {
    s"$String $s"
  }
}

val calculateSymbol = new CalculateSymbol
println(calculateSymbol concat "def")

//전위, 후위 연산자
class PrefixPostfix {
  var s = "PREFIXPOSTFIX"

  def unary_+() = 1

  def toLowerCaseS(): String = {
    s.toLowerCase()
  }
}

val prefixPostfix = new PrefixPostfix
println("abcd" toUpperCase)
println(+prefixPostfix)
print(prefixPostfix toLowerCaseS)

// 객체 동일성
val a = List(1, 2, 3)
val b = List(1, 2, 3)
println(a == b)
println(a.eq(b))

println(s"${1 == 1.0} ${1 == 1.0f}")
println(s"${1 == null} ${null == null}")

// 연산자 우선순위
class Order(arg: Int) {
  val n = arg
  def ::::(o: Order): Order = {
    println(o.n, n)
    new Order(o.n + n)
  }

  def ***(o: Order): Order = {
    println(o.n, n)
    new Order(o.n + n)
  }
}

val a = new Order(1)
val b = new Order(2)
val c = new Order(3)

a :::: b :::: c
a *** b *** c
c.::::(b).::::(a)
