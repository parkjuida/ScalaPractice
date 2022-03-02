1 +: List(1)

def a() = {
  val value = 1
  def b() = {
    println(value)
    val valueB = 2
  }
  b()
}