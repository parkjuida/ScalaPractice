
def isEqual(x: Int, y: Int) = {
  x == y
}

def isEqualAny(x: Any, y: Any) = {
  x == y
}

isEqual(1, 1)
isEqualAny(1, 1)

print("a" == "a")
print("a".equals("a"))
val a = new String("abc")
val b = new String("abc")
print(a equals b)
print(a eq b)

class A(val name: String)

val instanceA = new A("a")
val instanceB = new A("a")
print(instanceA equals instanceB)
print(instanceA eq instanceB)

// val i: Int = null

def returnError() = {
  throw new Error
}


def ifLagerThanOneReturnError(input: Int): Int = {
  if(input > 1) throw new Error
  input
}

//ifLagerThanOneReturnError(10)
ifLagerThanOneReturnError(-1)


class Dollars(val amount: Int) extends AnyVal {
  override def toString() = "$" + amount
}

val money = new Dollars(100)
money.amount
print(money)

def title(text: String, anchor: String, style: String): String =
  s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"

title("chap:vcls", "bold", "Value Classes")

class Anchor(val value: String) extends AnyVal
class Style(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value: String) extends AnyVal

def title(text: Text, anchor: Anchor, style: Style): Html =
  new Html(
    s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"
  )

title(
  new Anchor("chap:vcls"),
  new Style("bold"),
  new Text("Value Classes")
)