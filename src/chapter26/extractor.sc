import scala.util.matching.Regex

object Email {
  def apply(user: String, domain: String) = user + "@" + domain

  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if(parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

Email("bees1114", "gmail.com")

val x: Any = "bees1114@naver.com"

x match {
  case Email(user, domain) => println(user, domain)
  case _ => println("default")
}

object Twice {
  def apply(s: String): String = s + s
  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (half == s.substring(length)) Some(half) else None
  }
}

object UpperCase {
  def unapply(s: String): Boolean = s.toUpperCase == s
}

def userTwiceUpper(s: String) = s match {
  case Email(Twice(x @ UpperCase()), domain) =>
    "match: " + x + " in domain " + domain
  case _ => "no match"
}

userTwiceUpper("ABCDABCD@gmail.com")

Twice("abcd")

object Domain {
  def apply(parts: String*): String =
    parts.reverse.mkString(".")

  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)
}

"net" match {
  case Domain("org", "acm") => println("acm.org")
  case Domain("com", "sun", "java") => println("java.sun.com")
  case Domain("net", _*) => println("a .net domain")
}

"acm.org" match {
  case Domain("org", "acm") => println("acm.org")
  case Domain("com", "sun", "java") => println("java.sun.com")
  case Domain("net", _*) => println("a .net domain")
}

object ExpandedEMail {
  def unapplySeq(email: String)
    : Option[(String, Seq[String])] = {
    val parts = email split "@"
    if (parts.length == 2)
      Some(parts(0), parts(1).split("\\.").reverse)
    else
      None
  }
}

"abcd@company.gmail.com" match {
  case ExpandedEMail(user, others @ _*) => println(user, others)
}

val List(x, y_, r @ _*) = List(1, 2, 3, 4, 5)
print(x, y_, r)


case class A(val arg1: String, val arg2: String)

val y = new A("a", "b")
y match {
  case A(arg1, arg2) => println(arg1, arg2)
}

import scala.util.matching.Regex

val regexp = new Regex("\\d+")
val numbers = regexp.findAllMatchIn("a123def4").toList
numbers


val regexp2 = new Regex("""(-)(\d+)""")
regexp2.matches("-10")
regexp2.matches("10")

val regexp2(minus, ten @ _*) = "-10"
print(minus, ten)

val regexp3 = """(-)?([A-Z]+)(\d*)""".r

var regexp3(sign, word, number) = "-ABCD123"
print(sign, word, number)

var regexp3(sign, word, number) = "ABCD"
print(sign, word, number)

val Decimal = """(-)?(\\d+)(\\.\\d*)?"""r
