abstract  class  Element (val text:String){
  def accept(visitor:Visitor)
}

class Title(text:String) extends Element(text){
  override def accept(visitor: Visitor): Unit = {
    visitor.visit(this)
  }
}

class Text(text:String) extends Element(text){
  override def accept(visitor: Visitor): Unit = {
    visitor.visit(this)
  }
}

class HyperLink(text:String,val url:String) extends Element(text){
  override def accept(visitor: Visitor): Unit = {
    visitor.visit(this)
  }
}

class Document(parts: List[Element]) {
  def accept(visitor: Visitor) = {
    parts.foreach(p => p.accept(visitor))
  }
}



trait  Visitor{
  def visit(title:Title)
  def visit(text: Text)
  def visit(hyperLink:HyperLink)
}

class HtmlExportVisitor extends Visitor{
  val line = System.getProperty("line.separator")
  val builder = new StringBuilder


  override def visit(title: Title): Unit = {
    builder.append(s"<h1>${title.text}</h1>").append(line)
  }

  override def visit(text: Text): Unit ={
    builder.append(s"<p>${text.text}</p>").append(line)
  }

  override def visit(hyperLink: HyperLink): Unit = {
    builder.append(s"""<a href='${hyperLink.url}'>${hyperLink.text}</a>""").append(line)
  }

  def getHtml() = builder.toString()
}


object VisitorExample{
  def main(args: Array[String]): Unit = {
    val document = new Document(
      List(
        new Title("visitor pattern"),
        new Text("the visitor pattern helps us add extra function with out changing the class"),
        new HyperLink("Go check it online","http://www.so.com")
      )
    )

    val htmlExportVisitor = new HtmlExportVisitor
    println("**"* 20)
    document.accept(htmlExportVisitor)
    println(htmlExportVisitor.getHtml())
  }
}

