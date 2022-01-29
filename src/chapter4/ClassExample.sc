
// Class 선언
class Computer {
  val name = "MacBook"
  private val privateName = "MacBook Pro"

  def printPrivateName() = println(privateName)
  def call() = Computer.callNumber += 1
}

//Singleton object
object Computer {
  private var callNumber = 0

  def printCallNumber() = println(callNumber)
}

//create object
val macA = new Computer
val macB = new Computer
macA.call()
macB.call()
Computer.printCallNumber()
// println(mac.privateName) // 실행불가
macA.printPrivateName()

// method declaration
def add(first: Int, second: Int): Int = {
  first + second
}

// method can return more than one type
def hi(arg: Int) = {
  if(arg > 0) arg
  else "Negative"
}

// recursive method need return type
def recursive(arg: Int): Int = {
  if(arg < 1) 1
  else recursive(arg - 1)
}

object Singleton {
  val name = "Singleton"
}

println(Singleton.name)