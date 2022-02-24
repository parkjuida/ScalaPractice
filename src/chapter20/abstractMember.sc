trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class AbstractImpl extends Abstract {
  type T = String

  override def transform(x: T): String = x + x
  val initial = "hi"
  var current = "abcd"
}

trait Time {
  var hour: Int
  var minute: Int
}

trait AbstractTime {
  def hour(): Int
  def hour_=(h: Int)
  def minute(): Int
  def minute_=(m: Int)
}

val c = new Time {
  override var hour: Int = 1
  override var minute: Int = 10
}

def gcd(a: Int, b: Int): Int = {
  if(b == 0) a else gcd(b, a % b)
}

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
}

new {
  val numerArg: Int = 1
  val denomArg: Int = 2
} with RationalTrait

//new RationalTrait {
//  override val numerArg: Int = 1
//  override val denomArg: Int = 2
//}
//

class A extends {
  val numerArg = 10
  val denomArg = 20
} with RationalTrait

object NoLazyVal {
  val value = {println("initialization"); 0}
}

NoLazyVal

object LazyVal {
  lazy val value = {println("initialization"); 0}
}

LazyVal
LazyVal.value

trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  override def toString = s"$numer / $denom"
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int = {
    if(b == 0) a else gcd(b, a % b)
  }
}

val x = 2
new LazyRationalTrait {
  override val numerArg: Int = 1 + x
  override val denomArg: Int = 2 + x
}

class Food
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood) {}
}
class Grass extends Food
class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: SuitableFood): Unit = {
    print("cow eat grass.")
  }
}

class Pig extends Animal {
  type SuitableFood = Grass
  override def eat(food: SuitableFood) = {
    print("pig eat grass.")
  }
}

var grassEaters: List[Animal { type SuitableFood = Grass }] = List()
val p = new Pig()
val c = new Cow()

grassEaters = c :: p :: grassEaters
grassEaters


object Color extends Enumeration {
  val red, green, blue = Value
}

print(Color.red, Color.green, Color.blue)

object Color extends Enumeration