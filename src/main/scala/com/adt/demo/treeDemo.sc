import sun.font.GlyphLayout.LayoutEngineFactory

sealed trait  BinTree[+A]
case object Leaf extends BinTree[Nothing]
case class Branch[A](value:A,left:BinTree[A],right:BinTree[A]) extends BinTree[A]

def buildTree[A](list:List[A]):BinTree[A] = list match {
  case Nil => Leaf
  case x::xs =>{
    val k = xs.length/2
    Branch(x,buildTree(xs.take(k)),buildTree(xs.drop(k)))
  }
}


def size[A](tree:BinTree[A]):Int = tree match {
  case Leaf => 0
  case Branch(_,l,r) => 1 + size(l) + size(r)
}

def depth[A](tree: BinTree[A]):Int = tree match {
  case Leaf => 0
  case Branch(_,l,r) => 1 + (depth(l) max depth(r))
}

//构建完全二叉树


def buildCompleteTree(v:Int,depth:Int):BinTree[Int] = {
  if (depth == 0 ) {
    Leaf
  }else{
    Branch(v,buildCompleteTree(2*v,depth-1),buildCompleteTree(2*v+1,depth -1))
  }
}



def equal[A](t1:BinTree[A],t2:BinTree[A]):Boolean = (t1,t2) match {
  case (Leaf,Leaf) => true
  case (Branch(v1,l1,r1),Branch(v2,l2,r2)) if v1 == v2 =>
    equal(l1,l2) && equal(r1,r2)
  case _ =>
    false
}

//翻转树
def flip[A](tree:BinTree[A]):BinTree[A] = tree match {
  case Leaf => Leaf
  case Branch(v,l,r) => Branch(v,flip(r),flip(l))
}

def preorder[A](tree: BinTree[A]):List[A] = tree match {
  case Leaf => Nil
  case Branch(v,l,r) => v::(preorder(l) ++ preorder(r))
}


def preorderAcc[A](tree:BinTree[A],acc:List[A]):List[A]  = tree match {
  case Leaf => acc
  case Branch(v,l,r) =>
    println(s" when at ${v} - acc = ${acc}")
    v:: preorderAcc(l,preorderAcc(r,acc))
}


type Dictionary[A] = BinTree[(String,A)]

def insert[A](key:String,value:A,dictionary: Dictionary[A]):Dictionary[A]  = dictionary match  {
  case Leaf => Branch((key,value),Leaf,Leaf)
  case Branch((k,v),l,r) if (k == key) =>
    sys.error("key already present")
  case Branch((k,v),l,r) if (k > key) =>
    Branch((k,v),insert(key,value,l),r)
  case Branch((k, v), l, r) if (k < key) =>
    Branch((k, v),l, insert(key,value,r))
}

def search[A](key:String,dictionary: Dictionary[A]):Option[A] = dictionary match {
  case Leaf => None
  case Branch((k,v),l,r) if (k == key) => Some(v)
  case Branch((k, v), l, r) if (k > key) => search(key,l)
  case Branch((k, v), l, r) if (k == key) => search(key,r)
}

val l1 = (0 to 33 by 3).toList
l1.size
val tree = buildTree(l1)
size(tree)
depth(tree)

val tree2 = buildCompleteTree(1,8)

equal(tree,tree)
equal(tree,tree2)

val tree3 = flip(tree)

val ll = preorder(tree)
val ll2 = preorderAcc(tree,Nil)


