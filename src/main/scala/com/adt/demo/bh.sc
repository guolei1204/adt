case class Node(rank: Int, v: Int, children: List[Node])


def linkUp(t1: Node, t2: Node) = {
  if (t1.v < t2.v) {
    Node(t1.rank + 1, t1.v, t2 :: t1.children)
  } else {
    Node(t1.rank + 1, t2.v, t1 :: t2.children)
  }
}

def insert(t: Node, rootList: List[Node]): List[Node] = rootList match {
  case Nil => List(t)
  case x :: xs if (t.rank < x.rank) => t :: rootList
  case x :: xs => insert(linkUp(t, x), xs)
}

def insertElement(rtList: List[Node], elem: Int) = {
  insert(Node(0, elem, Nil), rtList)
}



def merge(l1: List[Node], l2: List[Node]): List[Node] = (l1, l2) match {
  case (ts1, Nil) => ts1
  case (Nil, ts2) => ts2
  case (t1 :: ts11, t2 :: ts22) if (t1.rank < t2.rank) => t1 :: merge(ts11, l2)
  case (t1 :: ts11, t2 :: ts22) if (t2.rank < t1.rank) => t2 :: merge(l1, ts22)
  case (t1 :: ts11, t2 :: ts22) => insert(linkUp(t1, t2), merge(ts11, ts22))
}

def findMin(rootList:List[Node]) = rootList min (Ordering.by((p:Node) => p.v))


def removeMin(root:List[Node]):List[Node] = {
  val min = findMin(root)
  val listExceptMin = root filterNot(_ == min)
  merge(listExceptMin,min.children)
}

val v1 = insertElement(Nil,11)
val v2 = insertElement(v1,2)
val v3 = insertElement(v2,9)
val v4 = insertElement(v3,29)
val v5 = insertElement(v4,17)
findMin(v3)