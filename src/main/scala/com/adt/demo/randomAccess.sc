import javax.swing.event.TreeExpansionListener

def increment(bL:List[Int]):List[Int] = bL match {
  case Nil => List(1)
  case 0::xs => 1::xs
  case 1::xs => 0::increment(xs)
  case _ => sys.error("Not a binary Number")
}

def add(one:List[Int],two:List[Int]):List[Int]  = (one,two) match {
  case (Nil,Nil) => Nil
  case (xs,Nil) => xs
  case (Nil,xs) => xs
  case (x::xs,0::ys) => x::add(xs,ys)
  case (0::xs,y::ys) => y::add(xs,ys)
  case (1::xs,1::ys) => 0::increment(add(xs,ys))
}



sealed abstract  class Tree {
  def size:Int
}

case class Leaf(n:Int) extends Tree{
  override def size = 1
}

case object Zero extends Tree{
  override def size = 0
}
case class One(t:Tree) extends Tree{
  override def size = t.size
}
case class Node(sz:Int,left:Tree,right:Tree) extends Tree{
  override def size = sz
}

//link to trees

def link(t1:Tree,t2:Tree) =Node(t1.size + t2.size,t1,t2)


def addTee2List(t1:Tree,listOfTree:List[Tree]):List[Tree] = listOfTree  match {
  case Nil => List(One(t1))
  case Zero::ts => One(t1)::ts
  case One(t2)::ts => Zero:: addTee2List(link(t1,t2),ts)
  case _ => sys.error("un support exception")
}


def cons(treeList:List[Tree],x:Int) = addTee2List(Leaf(x), treeList)



def searchTree(i:Int,tree:Tree):Int = (i,tree) match {
  case (0,Leaf(x)) => x
  case (i,Node(sz,left,right))  if (i < sz/2) =>
    searchTree(i,left)
  case (i,Node(sz,left,right)) =>
    searchTree(i - sz/2,right)
}

def lookup(i:Int,tree:List[Tree]):Int = tree match {
  case Zero::ts => lookup(i,ts)
  case One(t)::ts  if i < t.size => searchTree(i,t)
  case One(t)::ts if i>= t.size => lookup(i - t.size,ts)
}


def removeTree(tree:List[Tree]):(Tree,List[Tree])  = tree match {
  case One(t)::Nil => (t,Nil)
  case One(t)::xs =>(t,Zero::xs)
  case Zero::xs => {
    val (Node(_,t1,t2),tss) = removeTree(xs)
    (t1,One(t2)::xs)
  }
  case _ => sys.error("invalidate error")
}


def head(tree:List[Tree]) = removeTree(tree) match {
  case (Leaf(x),_) => x
}

def tail(tree:List[Tree]) = removeTree(tree) match {
  case (_,ts) => ts
}


def setValInTree(i:Int,newVal:Int,tree:Tree):Tree = (i,tree) match {
  case (0,Leaf(x)) => Leaf(newVal)
  case (_,Node(sz,t1,t2)) if (i < sz/2) => Node(sz,setValInTree(i,newVal,t1),t2)
  case (_,Node(sz ,t1,t2))  => Node(sz,t1,setValInTree(i-sz/2,newVal,t2))
}

def setVal(i:Int,newVal:Int,treeList:List[Tree]):List[Tree] = treeList match {
  case Zero::ts => setVal(i,newVal,ts)
  case One(t)::ts if i < t.size => One(setValInTree(i,newVal,t))::ts
  case One(t)::ts => One(t)::setVal(i-t.size,newVal,ts)
}


val tree = List(11,12,13,14,15,16).reverse
val tl = tree.foldLeft(List.empty[Tree])((a,b) => cons(a,b))
lookup(0,tl)
lookup(1,tl)
head(tl)
tail(tl)

setVal(3,99,tl)

