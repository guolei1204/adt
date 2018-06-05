sealed  abstract class TreeNode {
  def rank:Int
}


case class Node(rank:Int,v:Int,left:TreeNode,right:TreeNode) extends TreeNode

case object Leaf extends TreeNode{
  override def rank: Int = 0
}

def makeNode(v:Int,left:TreeNode,right:TreeNode):Node = {
  if (left.rank >= right.rank) Node(left.rank +1,v,left,right)
  else Node(right.rank +1 ,v,right,left)
}

def merge(node1:TreeNode,node2:TreeNode):TreeNode = (node1,node2) match {
  case (node1,Leaf) => node1
  case (Leaf,node2) => node2
  case (Node(_,x,l1,r1),Node(_,y,l2,r2))  => {
    if (x < y) makeNode(x,l1,merge(r1,node2))
    else makeNode(y,l2,merge(node1,r2))
  }
}

def insert(v:Int,h:TreeNode):TreeNode = {
  val singleTree = makeNode(v,Leaf,Leaf)
  merge(singleTree,h)
}


def min(h:TreeNode):Int = h match {
  case Leaf => throw new IllegalArgumentException("empty tree")
  case (Node(_,x,_,_)) => x
}

def pop(h:TreeNode):(Int,TreeNode) = h match {
  case Leaf => throw new IllegalArgumentException("empty tree")
  case (Node(_,x,l,r)) => (x,merge(l,r))
}


val tree = insert(1, insert(88, insert(9, insert(12, Leaf))))
val (v,t) = pop(tree)
pop(t)
