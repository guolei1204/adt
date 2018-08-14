trait  ContainerT{
  type T
  val data: T
  def compare(other:T) = data.equals(other)
}

class StringContainer(val data:String) extends ContainerT{
  override type T = String
}

val stringContainer = new StringContainer("haha")
stringContainer.compare("haha")
