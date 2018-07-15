import scala.collection.mutable.ListBuffer

trait Observer[T]{
  def handleUpdate(subject:T)
}

trait Observable[T]{
  this:T =>
  private val observers = ListBuffer[Observer[T]]()

  def addObserver(observer: Observer[T]) = {
    observers.+=:(observer)
  }

  def notifyObservers() = {
    observers.foreach(_.handleUpdate(this))
  }
}

case class User(name:String) extends  Observer[Post] {
  override def handleUpdate(subject: Post) = {
    System.out.println(s"Hey I'am ${name} . The post got some comments : ${subject.comments}")
  }
}

case class Post(user:User,text:String) extends Observable[Post]{
  val comments = ListBuffer[Comment]()

  def addComment(comment: Comment) = {
    comment +=: comments
    notifyObservers()
  }
}

case class Comment(user:User,text:String)

object PostDemo {

  def main(args: Array[String]): Unit = {
    val user1 = User("u1")
    val user2 = User("u2")
    val user3 = User("u3")
    val user4 = User("u4")

    println("create a post")
    val post = Post(user1,"this is a post about observer patterns")
    println("add comment")
    post.addComment(Comment(user2,"like it"))
    println("add comment")
    post.addComment(Comment(user3,"well done"))
    println("add comment")
    post.addComment(Comment(user4,"good job"))

  }
}