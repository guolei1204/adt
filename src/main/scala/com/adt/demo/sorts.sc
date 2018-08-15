import scala.math

def bubbleSort[T <% Ordered[T]](data: List[T]): List[T] = data match {
  case Nil => Nil
  case _ =>
    val (x, rs) = getLargest(data)
    bubbleSort(rs) ::: List(x)
}


def getLargest[T <% Ordered[T]](data: List[T]): (T, List[T]) = data match {
  case (Nil) => (null.asInstanceOf[T], Nil)
  case (fv :: Nil) => (fv, Nil)
  case (fv :: fl) => {
    val (fd, lso) = getLargest(fl)
    if (fd >= fv)
      (fd, fv :: lso)
    else
      (fv, fd :: lso)
  }
}

def getMin[T <% Ordered[T]](data: List[T]): (T, List[T]) = data match {
  case (Nil) => (null.asInstanceOf[T], Nil)
  case (fv :: Nil) => (fv, Nil)
  case (fv :: xs) => {
    val (rv, res) = getMin(xs)
    if (fv >= rv) {
      (rv, fv :: res)
    } else {
      (fv , xs)
    }
  }
}

println("####")
val testMinList  = List(33,2,89,7)
val (m,_) = getMin(testMinList)
println(s"min test : ${m}")
println("####")


def selectSort[T <% Ordered[T]](data: List[T]): List[T] = data match {
  case Nil => Nil
  case x :: Nil => List(x)
  case x :: xs =>
    val (minData,_) = getMin(xs)
    val minIndex = xs.indexOf(minData)
    if (x <= minData) {
      x :: selectSort(xs)
    } else {
      val (f, l) = xs.splitAt(minIndex)
      l.head :: selectSort(f ::: (x :: l.tail))
    }
}

def insertElement[T <% Ordered[T]](ele:T,sorted:List[T]):List[T] = sorted match {
  case Nil => ele::Nil
  case x::xs => {
    if(ele <= x){
      ele :: sorted
    }else{
      x :: insertElement(ele, xs)
    }
  }
}

def s = List(2,3,9)

def insertSort[T <% Ordered[T]](data:List[T],sorted:List[T]):List[T] = data match {
  case Nil => sorted
  case x::Nil => insertElement(x,sorted)
  case x::xs => insertSort(xs,insertElement(x,sorted))
}



def mergeSort[T <% Ordered[T]](data:List[T]):List[T] ={
  if(data.head == Nil || data.tail == Nil){
    return data
  }
  val (l1,l2) = data.splitAt(data.length / 2)
  merge(l1,l2)
}


def merge[T <% Ordered[T]](l1: List[T], l2: List[T]): List[T] = (l1, l2) match {
  case (Nil, Nil) => Nil
  case (Nil, l2) => l2
  case (l1, Nil) => l1
  case (x :: xs, y :: ys) => {
    if(x > y){
      y::merge(l1,ys)
    }else{
      x::merge(xs,l2)
    }
  }
}

def quickSort[T <% Ordered[T]](data: List[T]): List[T] = data match {
  case Nil => Nil
  case x :: xs =>
    (quickSort(xs.filter(_ < x)) :+ x) ::: quickSort(xs.filter(_ > x))
}


val m1 = List(1,3,5)
val m2 = List(2,4,6)
println("merge test")
merge(m1,m2)


def l1 = List(3, 9, 6, 2, 10)
println(s"list is ${l1}")
println("bubble sort --")
bubbleSort(l1)
println("####" * 20)
println("select sort")
selectSort(l1)
println("insert sort")
insertSort(l1,List.empty[Int])
println("merge sort")
mergeSort(l1)
println("quick sort")
quickSort(l1)

