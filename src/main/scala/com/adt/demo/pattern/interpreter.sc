import java.util.StringTokenizer

trait  Expression{
  def interpret():Int
}

class Number(n:Int) extends Expression {
  def interpret(): Int = n
}

class AddExpression(left: Expression,right: Expression) extends Expression{
  override def interpret() = left.interpret() + right.interpret()
}

class SubExpression(left: Expression,right: Expression) extends Expression{
  override def interpret() = left.interpret() - right.interpret()
}

class MultiExpression(left: Expression,right: Expression) extends Expression{
  override def interpret(): Int = left.interpret() * right.interpret()
}

class DivideExpression(left: Expression,right: Expression) extends Expression{
  override def interpret(): Int = left.interpret() / right.interpret()
}

object Expression{
  def apply(operator:String,left: => Expression,right: => Expression): Option[Expression] = operator match {
    case "+"  => Some(new AddExpression(left,right))
    case "-"  => Some(new SubExpression(left,right))
    case "*"  => Some(new MultiExpression(left,right))
    case "/"  => Some(new DivideExpression(left,right))
    case n if n.matches("\\d+") => Some(new Number(n.toInt))
    case _ => None
  }
}
import scala.collection.JavaConverters._
import scala.collection.mutable

class RPNParser {

  def parse(expression: String): Expression = {
    val tokenizer = new StringTokenizer(expression)
    tokenizer.asScala.foldLeft(mutable.Stack[Expression]()) {
      case (result, token) =>
        val item = Expression(token.toString, result.pop(), result.pop())
        item.foreach(result.push)
        result
    }.pop()
  }
}

class RPNInterpreter {
  def interpret(expression: Expression): Int = expression.interpret()
}

object RPNExample {
  def main(args: Array[String]): Unit = {
    val expr1 = "1 2 + 3 * 9 10 + -" // (1 + 2) * 3 - (9 + 10) = -10
    val expr2 = "1 2 3 4 5 * * - +" // 1 + 2 - 3 * 4 * 5 = -57
    val expr3 = "12 -" // invalid
    val parser = new RPNParser
    val interpreter = new RPNInterpreter

    System.out.println(s"The result of '${expr1}' is: ${interpreter.interpret(parser.parse(expr1))}")
    System.out.println(s"The result of '${expr2}' is: ${interpreter.interpret(parser.parse(expr2))}")
    try {
      System.out.println(s"The result is: ${interpreter.interpret(parser.parse(expr3))}")
    } catch {
      case _: Throwable => System.out.println(s"'$expr3' is invalid.")
    }
  }
}
