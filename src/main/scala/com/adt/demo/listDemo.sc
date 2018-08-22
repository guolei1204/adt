import scala.annotation.tailrec

sealed trait List[+A]

case object Nil extends List[Nothing]

case class ::[+A](head: A, tail: List[A]) extends List[A]

def apply[A](as: A*): List[A] =
  if (as.isEmpty) Nil else ::(as.head, apply(as.tail: _*))


def head[A](list: List[A]): A = list match {
  case Nil => sys.error("list is empty")
  case ::(x, _) => x
}

def tail[A](list: List[A]): List[A] = list match {
  case Nil => sys.error("list is empty")
  case _ :: xs => xs
}

def drop[A](l: List[A], n: Int): List[A] = {
  if (n <= 0) {
    l
  }else{
    l match {
      case Nil => Nil
      case _::rest => drop(rest,n - 1)
    }
  }
}

def  dropWhile[A](l:List[A])(f:A => Boolean):List[A] =  l match {
  case x::xs if f(x) => dropWhile(xs)(f)
  case _ => l
}


def ++[A](l1:List[A],l2:List[A]):List[A] = l1 match {
  case Nil => l2
  case x::xs => ::(x,++(xs,l2))
}


def prepend[A](list: List[A],v:A):List[A] = list match {
  case Nil => ::(v,Nil)
  case x::xs => ::(v,list)
}

def elemAtIndex[A](l:List[A],i:Int):A = (l,i) match {
  case (Nil,_) => sys.error("list is empty")
  case (x::xs,0) => x
  case (x::xs,_) => elemAtIndex(xs,i-1)
}

// set element at position n

def setElement[A](l:List[A],i:Int,elem:A):List[A] = (l,i) match {
  case (Nil,_) => sys.error(s"index ${i} is invalid")
  case (xs,0) => ::(elem,xs)
  case (x::xs,_) => ::(x,setElement(xs,i -1 ,elem))
}

def foldLeft[A](data:List[A])(op:(A,A)=> A):A = data match {
  case Nil => sys.error("can not fold left empty list")
  case x::Nil => x
  case x::y::xs =>{
    foldLeft(::(op(x, y),xs))(op)
  }
}




def reverse[A](data:List[A]):List[A] = {
  @tailrec
  def rev(source:List[A],dest:List[A]):List[A] = {
     source match {
       case Nil => dest
       case x::xs => rev(xs,::(x,dest))
     }
  }
  rev(data,Nil)
}

def foldRight[A](data:List[A])(op:(A,A) => A):A = foldLeft(reverse(data))(op)

print("reverse ===========")
val source = apply(1, 2, 3, 4)
print(source)
print(reverse(source))
print("reverse ===========")

print("fold right ==============")
foldRight(source)(_ + _)
print("fold left ==============")
val result = foldLeft(apply(1,2,3,4))(_ + _)
println(s"result + ${result}")
print("fold ==============")



val l1 = apply(1, 2, 3, 4)
val l2 = apply(5,6)
head(l1)
tail(l1)
drop(l1,2)
def lessThan2: Int => Boolean = (x:Int) => x < 2
println("drop while less than 2")
dropWhile(l1)(lessThan2)
println("drop while less than 4")
dropWhile(l1)(_ <= 2)

++(l1,l2)

prepend(l1,0)

print("find element A at position i")


elemAtIndex(l1,0)











