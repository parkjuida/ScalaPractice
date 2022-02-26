import java.awt.event.{ActionEvent, ActionListener}

import javax.swing.JButton

val button = new JButton()
button.addActionListener(
  new ActionListener {
    def actionPerformed(event: ActionEvent) = {
      println("pressed")
    }
  }
)

button.addActionListener(
  (_: ActionEvent) => println("pressed")
)

implicit def doubleToInt(x: Double): Int = {
  x.toInt
}

def NeedIntegerButDoubleGiven(input: Int): Int = {
  input * 10
}

NeedIntegerButDoubleGiven(1.5)

class A
class B {
  def whoami() = println("I`m B")
}

implicit def classAToB(a: A) = {
  new B()
}

val a = new A()
a.whoami

class Rational(n: Int, d: Int) {
  val numer = n
  val denom = d

  def +(int: Int) = {
    new Rational(n + int * denom, denom)
  }

  def +(that: Rational) = {
    new Rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom)
  }

  override def toString: String = {
    s"$numer / $denom"
  }
}

implicit def intToRational(x: Int): Rational = {
  new Rational(x, 1)
}

new Rational(1, 2) + 1
1 + new Rational(1, 2)

a -> 1

case class Rectangle(width: Int, height: Int)

implicit class RectangleMaker(width: Int) {
  def x(height: Int) = Rectangle(width, height)
}

1 x 2

// 5 implicit parameter
class PreferredPrompt(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt) = {
    println("Welcome, " + name + ". The system is ready.")
    println(prompt.preference)
  }
}

Greeter.greet("Park")(new PreferredPrompt("greet > "))

implicit val p = new PreferredPrompt("implicit prompt")
Greeter.greet( "Implicit Park")


def maxListOrdering[T](elements: List[T])(implicit ordering: Ordering[T]): T = elements match {
  case List() => throw new IllegalArgumentException("empty list!")
  case List(x) => x
  case x :: rest =>
    val maxRest = maxListOrdering(rest)
    if(implicitly[Ordering[T]].gt(x, maxRest)) x
    else maxRest
}

maxListOrdering(List(1, 3, 2, 4))

def maxList[T : Ordering](elements: List[T]): T =
  elements match {
    case List() =>
      throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxList(rest)
      if (implicitly[Ordering[T]].gt(x, maxRest)) x
      else maxRest
  }