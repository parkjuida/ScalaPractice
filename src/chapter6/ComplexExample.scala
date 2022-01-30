package chapter6

object ComplexExample extends App {
  val complexNumberB = new ComplexNumber(3 ,4)

  implicit def intToComplexNumber(x: Int) = new ComplexNumber(2, 0)

  println(2 * complexNumberB)
}
