import ProgrammingInScala.ch15._

//val  v = Var("x")
//
//val op = BinOp("+", Number(1), v)
//v.name
//op.left
//println(op)
//op.right == Var("x")
//
//op.copy(operator = "-")
//
//
//def simplifyTop(expr: Expr): Expr = expr match {
//  case UnOp("-", UnOp("-", e)) => e //부호를 두 번 반전
//  case BinOp("+", e, Number(0)) => e //0을 더함
//  case BinOp("*", e, Number(1)) => e //1을 곱함
//  case _ => expr
//}
//
//def describe(x: Any) = x match {
//  case 5 => "five"
//  case true => "truth"
//  case "hello" => "hi!"
//  case Nil => "the empty list"
//  case _ => "something else"
//}
//
//describe(5)
//describe(true)
//describe("hello")
//describe(Nil)
//describe(null)
//describe(List(1,2,3))
//
//import math.{E, Pi}
//
//E match {
//  case Pi => "strange math? Pi =" + Pi
//  case _ => "Ok"
//}
//
//val pi = math.Pi
//
//E match {
//  case `pi` => "strange math? Pi="+pi
//  case _ => "OK!"
//}
//
//def simplifyAdd(e:Expr) = e match {
//  case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
//  case _ => e
//}
//
//simplifyAdd(BinOp("+", Number(2), Number(2)))
//
//val capitals = Map("France"->"Paris","Japan"->"Tokyo")
//capitals get "France"
//capitals get "Korea"
//
//def show(x: Option[String]) = x match {
//  case Some(s) => s
//  case None => "?"
//}
//
//show(capitals get "France")
//show(capitals get "Korea")

val myTyple = (123,"abc")
val (number, string) = myTyple
number
string
