val graph = List(("m", "n"), ("m", "o"), ("m", "p"), ("n", "q"), ("o", "r"), ("p", "q"), ("q", "r"), ("q", "s"))

def succSet(a:String,g:List[(String,String)]):List[String] = g match {
  case Nil => Nil
  case x::xs  if(x._1) ==a => x._2::succSet(a,xs)
  case _ :: xs => succSet(a,xs)
}


//profile edition
def succFilter(a: String, g: List[(String, String)]): List[String] = g.filter(_._1 == a).map(_._2)


def depthFirst(init:String,g:List[(String,String)]):List[String] = {

  def depthF(nodes:List[String],visited:List[String]):List[String]  = nodes match {
    case Nil => visited
    case x::xs if visited.contains(x) => depthF(xs,visited)
    case x::xs => depthF(succSet(x,g)++xs, x::visited)
  }
  val result = depthF(List(init),List.empty[String])
  result.reverse
}


def depthFirstProfile(init: String, g: List[(String, String)]): List[String] = {

  def depthF(nodes: List[String], visited: List[String]): List[String] = nodes match {
    case Nil => visited
    case x :: xs =>
      depthF(xs, if (visited.contains(x)) {
        visited
      } else {
        depthF(succFilter(x, g), x :: visited)
      })
  }
  depthF(List(init),Nil).reverse
}


def widthFistProfile(init:String,g:List[(String,String)]):List[String] = {
  Nil
}

succSet("m",graph)
depthFirst("m",graph)

print("profiled depth first graph")
depthFirstProfile("m",graph)