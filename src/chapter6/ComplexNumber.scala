package chapter6

class ComplexNumber(r: Double, i: Double) {
  // require(i != 0) 정수를 변환할 수 있도록 하기위해 이 제약조건은 제거하였다.
  val real = r
  val imaginary = i
  override def toString = s"$real + ${imaginary}i"

  def this(i: Double) = this(0, i)

  def add(other: ComplexNumber): ComplexNumber = {
    new ComplexNumber(real + other.real, imaginary + other.imaginary)
  }

  def + (other: ComplexNumber): ComplexNumber = {
    add(other)
  }

  def * (other:ComplexNumber): ComplexNumber = {
    val real = this.real * other.real - this.imaginary * other.imaginary
    val imaginary = this.real * other.imaginary + this.imaginary * other.real
    new ComplexNumber(real, imaginary)
  }

  def * (r: Int): ComplexNumber = {
    new ComplexNumber(real * r, imaginary * r)
  }
}
