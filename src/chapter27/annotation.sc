@deprecated def deprecatedMethod(): Unit = {

}

sealed class Super()
case class A() extends Super
case class B() extends Super


def seeUnchecked(instance: Super): Unit = (instance: @unchecked) match {
  case A() => println("A")
}

seeUnchecked(new A())

@deprecated def bigMistake()
@deprecated(
  "This method will be removed. use OtherMethod()."
) def bigMistake()

@volatile val someVariable: Int = 10

@SerialVersionUID(1234) class A {
  val userId: String
  @transient val password: String
}