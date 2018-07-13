import java.util.StringTokenizer

trait  Expression{
  def interpret():Int
}

class Number(n:Int) extends Exception{
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
    case ""  => Some(new DivideExpression(left,right))
    case n if n.matches("\\d+") => Numeric(n.toInt)
    case _ => None
  }
}
import scala.collection.JavaConverters._
import scala.collection.mutable

class RPNPaser {

  def parse(expression:String)= {
    val tokenizer = new StringTokenizer(expression)
    tokenizer.asScala.foldLeft(mutable.Stack[Expression]){
      case (result,token) =>
    }
  }
}

