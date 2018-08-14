abstract class Json

case class Str(value:String) extends Json
case class Num(value:Int) extends Json
case class Dict(pairs:(String,Json)*) extends Json

abstract class Visitor[T]{
  def visitStr(value:String):T
  def visitNum(value:String):T
  def visitDict():DictVisitor[T]
}
abstract class DictVisitor[T]{
  def visitKey(key:String):Unit
  def visitValue():Visitor[T]
  def visitValue(value:T):Unit
  def done():T
}

def dispatch[T](input:Json,visitor:Visitor[T]):T = {
  input match {
    case Str(value) => visitor.visitStr(value)
    case Num(value) => visitor.visitNum(value.toString)
    case Dict(pairs@ _*) =>
    val dictVistor = visitor.visitDict()
      for((k,v)  <- pairs){
        dictVistor.visitKey(k)
        val subVistor = dictVistor.visitValue()
        dictVistor.visitValue(dispatch(v,subVistor))
      }
      dictVistor.done()
  }
}
