import scala.collection.mutable
trait Memento[T]{
  protected  val state: T
  def getState():T = state
}

trait CareTaker[T]{
  val status= mutable.Stack[Memento[T]]()
}

trait  Originator[T]{
  def createMemento: Memento[T]
  def restore(memento: Memento[T])
}

class TextEditor extends Originator[String] {
  private var builder = new StringBuilder

  def append(text:String)  = {
    builder.append(text)
  }

  def delete():Unit = {
    if (builder.nonEmpty){}
    builder.deleteCharAt(builder.length -1)
  }

  def text() = builder.toString()

  override def createMemento: Memento[String] = new TextEditorMemento(builder.toString())

  override def restore(memento: Memento[String]): Unit = {
    this.builder = new StringBuilder(memento.getState())
  }

  private class TextEditorMemento(val state:String) extends Memento[String]
}

class TextEditorManipulator extends CareTaker[String]{
  private  val textEditor = new TextEditor

  def save() = {
    status.push(textEditor.createMemento)
  }

  def undo() = {
    if (status.nonEmpty){
      textEditor.restore(status.pop())
    }
  }

  def append(text:String) = {
    save()
    textEditor.append(text)
  }

  def delete() = {
    save()
    textEditor.delete()
  }

  def readText():String = textEditor.text()
}

object TextEditorDemo {
  def main(args: Array[String]): Unit = {
    val textEditorManipulator = new TextEditorManipulator
    textEditorManipulator.append("this is a string")
    println(textEditorManipulator.readText())
    println("delete 2 characters")

    textEditorManipulator.delete()
    textEditorManipulator.delete()

    println(textEditorManipulator.readText())

    println("Undoing ....")
    textEditorManipulator.undo()
    println("Undoing ......")
    textEditorManipulator.undo()
    println(s"after undo ${textEditorManipulator.readText()}")
  }
}