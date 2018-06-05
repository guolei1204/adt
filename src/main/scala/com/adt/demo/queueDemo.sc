case class FiFo(out:List[Int],in:List[Int]){
  def check():Boolean = (out,in) match {
    case (Nil,x::xs) => false
    case _ => true
  }
  require(check(),"Invariant Failed - out.em")
}


def push(e:Int,queue:FiFo):FiFo ={
  val newIn = e::queue.in
  queue.out match {
    case Nil => FiFo(newIn.reverse,Nil)
    case _ => queue.copy(in = newIn)
  }
}

def pop(queue:FiFo):(Int,FiFo) = {
  queue.out match {
    case Nil => throw new IllegalArgumentException("empty queue")
    case x::Nil => (x,queue.copy(out =  queue.in.reverse,Nil))
    case y::ys => (y,queue.copy(out = ys))
  }
}

val q = push(3,push(2,push(1,FiFo(Nil,Nil))))
pop(q)
