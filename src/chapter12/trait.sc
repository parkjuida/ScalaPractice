import scala.collection.mutable.ArrayBuffer

trait Philosophical {
  def philosophize() = {
    println("나는 메모리를 사용한다, 고로 존재한다!")
  }
}

class Person extends Philosophical {
  val name = "Kim"
}

val p = new Person
p.philosophize()

val philosophical: Philosophical = new Person
philosophical.philosophize()

class Human
trait Philosophical {
  def philosophize() = {
    println("나는 메모리를 사용한다, 고로 존재한다.")
  }
}


class Programmer extends Human with Philosophical
val programmer = new Programmer
programmer.philosophize()


class Rational(n: Int, d: Int) {
  val numer = n
  val denom = d
  def < (that: Rational) = this.numer * that.denom < this.denom * that.numer
  def > (that: Rational) = that < this
  def <= (that: Rational) = (this < that) || (this == that)
  def >= (that: Rational) = (this > that) || (this == that)
}

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  val numer = n
  val denom = d

  def compare(that: Rational) = this.numer * that.denom - this.denom * that.numer
}

val r1 = new Rational(1, 2)
val r2 = new Rational(1, 10)

r1 < r2
r1 > r2


// 쌓을 수 있는 변경
abstract class IntQueue {
  def get(): Int
  def put(input: Int): Unit
}

class BasicIntQueue extends IntQueue {
  private val buffer = new ArrayBuffer[Int]

  def get(): Int = buffer.remove(0)

  def put(input: Int): Unit = { buffer += input }

}

val queue = new BasicIntQueue
queue.put(1)
queue.put(2)
queue.put(3)

print(queue.get())
print(queue.get())
print(queue.get())

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = {super.put(2 * x)}
}

val doubleQueue = new BasicIntQueue with Doubling
doubleQueue.put(10)
doubleQueue.get()


trait Incrementing extends IntQueue {
  abstract override def put(input: Int): Unit = { super.put(input + 1)}
}

trait Filtering extends IntQueue {
  abstract override def put(input: Int): Unit = {
    if(input > 0) {
      super.put(input)
    }
  }
}

val queue = (new BasicIntQueue with Incrementing with Filtering)
queue.put(0)
queue.put(1)
queue.put(2)
queue.get()
queue.get()

val queue = (new BasicIntQueue with Filtering with Incrementing)
queue.put(0)
queue.put(1)
queue.put(2)
queue.get()
queue.get()
queue.get()