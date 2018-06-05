sealed  trait  Color
case object Red extends Color
case object Black extends Color


sealed  abstract class Tree{
  def color:Color
}

case class Node(color: Color, left:Tree, value: Int, right:Tree) extends Tree{
  override def toString = s"color:${color.toString}  left: ${left.toString} value:${value.toString} right: ${right.toString}"
}

case object End extends Tree{
  override def toString = "."
  override val color = Black
}


def insert(v:Int,tree: Tree) = {
  def ins(s:Tree):Tree = s match {
    case End => Node(Red,End,v,End)
    case node@Node(_,left,value,right) =>
      val root = if(v < value){
        balance(node.copy(left = ins(left)))
      }else{
        node
      }
      root match {
        case node@Node(Red,_,_,_) => node.copy(color = Black)
        case _ => root
      }
  }
  ins(tree)
}

def balance(color: Color,left: Tree,right:Tree,v:Int):Tree = {
  (color,left,v,right) match {
    case(Node(Black,gParent@Node(Red,parent@Node(Red,ggChild1,_,ggChild2),_,gChild),_,child)) =>
      gParent.copy(Red,left = parent.copy(color=Black),right = gg)
  }
}