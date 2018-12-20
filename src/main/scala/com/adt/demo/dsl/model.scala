//import scala.collection.mutable.HashMap
//import scala.util.parsing.input.Positional
//
////  Expr
//class Expr extends Positional
//
//case class Number(value: Int) extends Expr
//
//
//case class Operator(op: String, var left: Expr, var right: Expr) extends Expr
//
//case class Identifier(name: String) extends Expr
//
////statement
//trait Statement extends Positional
//
//// Variable
//case class Variable(name: String, value: Expr) extends Statement
//
////Scope
//class Scope(val name: String, val parentScope: Scope) {
//  var variables = new HashMap[String, Expr]
//}
//
////condition
//class Condition(val op: String, val left: Expr, val right: Expr)
//
////if statement
//
//case class IfStatement(condition: Condition, trueBranch: List[Statement], falseBranch: List[Statement]) extends Statement
//
//case class PrintStatement(value: Expr) extends Statement
//
//case class Function(name: String, arguments: Map[String, Int], statement: List[Statement], val rthValue: Expr)
//
//case class CallFunctionMethod(name: String, values: Map[String, Expr]) extends Expr with Statement
//
//
//class Program(val funtions: List[Function], val statements: List[Statement])
//
//val inputStr =
//  """
//    |SUB MAIN
//    |   printVoid()
//    |END SUB
//    |
//    |FUNCTION printVoid()
//    | PRINT "hello world"
//    |END FUNCTION
//    |
//  """.stripMargin
//
//import scala.util.parsing.combinator.syntactical.StandardTokenParsers
//
//class Reader extends StandardTokenParsers {
//  lexical.reserved += ("DIM", "PRINT", "IF", "THEN", "FUNCTION", "SUB", "MAIN", "RETURN", "END FUNCTION")
//  lexical.delimiters += ("*", "/", "%", "+", "-", "(", ")", "=", "<", ">", "==", "!=", "<=", ">=", ",", ":")
//
//  def mainPoint: Parser[Program] = (rep(function) <~ ("SUB" ~ "MAIN")) ~ block ^^ {
//    case f ~ c => new Program(f, c)
//  }
//
//  def function: Parser[Function] = ("FUNCTION" ~> ident) ~ ("(" ~> arguments) ~ (")" ~> block) ~ opt(returnStatement) <~ "END FUNCTION" ^^ {
//    case a ~ b ~ c ~ None => new Function(a, b, c, Number(0))
//    case a ~ b ~ c ~ d => new Function(a, b, c, d.get)
//  }
//
//  def returnStatement: Parser[Expr] = "RETURN" ~> expr ^^ {
//    e => e
//  }
//
//  def arguments: Parser[Map[String, Int]] = repsep(ident, ",") ^^ {
//    argumentList => {
//      (for (a <- argumentList) yield (a -> 0)) toMap
//    }
//  }
//
//  def block: Parser[List[Statement]] = rep(statement) ^^ { a => a }
//
//  def statement: Parser[Statement] = positioned(variableAssignment | outStatement | ifStatement | executeFunction | outStatement) ^^ { a => a }
//
//  def variableAssignment: Parser[Variable] = "DIM" ~> ident ~ "=" ~ positioned(executeFunction | expr) ^^ { case a ~ "=" ~ b => {
//    new Variable(a, b)
//  }
//  }
//
//  def outStatement: Parser[PrintStatement] = "PRINT" ~> positioned(expr) ^^ { case a => new PrintStatement(a) }
//
//  def ifStatement: Parser[IfStatement] = conditional ~ block ^^ {
//    case a ~ b ~ c => {
//      c match {
//        case None => new IfStatement(a, b, List())
//        case _ => new IfStatement(a, b, c.get)
//      }
//    }
//  }
//
//  def conditional: Parser[Condition] = "IF" ~ "(" ~> condition <~ ")" ~ "THEN"
//
//  def condition: Parser[Condition] = positioned(expr) ~ ("<" | ">" | "==" | "!=" | "<=" | ">=") ~ positioned(expr) ^^ {
//    case a ~ b ~ c => {
//      new Condition(b, a, c)
//    }
//  }
//
//  def iterations: Parser[Int] = numericLit ^^ {
//    _ toInt
//  }
//
//  def executeFunction: Parser[CallFunctionMethod] = ((ident) <~ "(") ~ callFunctionMethod <~ ")" ^^ {
//    case a ~ l => new CallFunctionMethod(a, l)
//  }
//
//  def functionCallArguments: Parser[Map[String, Expr]] = repsep(functionArgument, ",") ^^ {
//    _ toMap
//  }
//
//  def functionArgument: Parser[(String, Expr)] = (ident <~ "=") ~ expr ^^ {
//    case a ~ b => (a, b)
//  }
//
//  def expr: Parser[Expr] = term ~ rep(("+" | "-") ~ term) ^^ {
//    case a ~ List() => a
//    case a ~ b => {
//      def appendExpression(c: Operator, p: Operator): Operator = {
//        p.left = c
//        p
//      }
//
//      var root: Operator = new Operator(b.head._1, a, b.head._2)
//
//      for (f <- b.tail) {
//        var parent =
//          f._1 match {
//            case "+" => new Operator("+", null, f._2)
//            case "-" => Operator("-", null, f._2)
//          }
//
//        root = appendExpression(root, parent)
//      }
//
//      root
//    }
//  }
//
//  def term: Parser[Expr] = multiplydividemodulo ^^ { l => l } | factor ^^ {
//    a => a
//  }
//
//  def multiplydividemodulo: Parser[Expr] = factor ~ rep(("*" | "/" | "%") ~ factor) ^^ {
//
//    case a ~ List() => a
//    case a ~ b => {
//      def appendExpression(e: Operator, t: Operator): Operator = {
//        t.left = e.right
//        e.right = t
//        t
//      }
//
//      var root: Operator = new Operator(b.head._1, a, b.head._2)
//      var current = root
//
//      // for each of these, i'm just building up the parse tree
//      for (f <- b.tail) {
//        var rightOperator =
//          f._1 match {
//            case "*" => Operator("*", null, f._2)
//            case "/" => Operator("/", null, f._2)
//            case "%" => Operator("%", null, f._2)
//          }
//
//        current = appendExpression(current, rightOperator)
//      }
//
//      root
//    }
//  }
//
//  def factor: Parser[Expr] = numericLit ^^ { a => Number(a.toInt) } |
//    "(" ~> expr <~ ")" ^^ { e => e } |
//    ident ^^ {
//      new Identifier(_)
//    }
//
//  def parseAll[T](p: Parser[T], in: String): ParseResult[T] = {
//    phrase(p)(new lexical.Scanner(in))
//  }
//}
