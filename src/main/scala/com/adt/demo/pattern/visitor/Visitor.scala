package com.adt.demo.pattern.visitor

import java.io.File

import com.adt.demo.pattern.visitor
import javax.swing.text.Document


abstract class Element(text:String) {
  def accept(visitor: Element => Unit) = {
    visitor(this)
  }
}

case class Title(text:String) extends Element(text)
case class Text(text: String) extends Element(text)
case class HyperLink(text: String,url:String) extends Element(text)

class Document(parts: List[Element]){
  def accept(visitor:Element => Unit) = {
    parts.foreach(_.accept(visitor))
  }
}


object VisitorExample{
  val separator = System.getProperty("line.separator")

  def htmlExportVisitor(builder: StringBuilder): Element => Unit  = {
    case Title(t) =>
      builder.append(s"<h1>${t}</h1>").append(separator)
    case Text(t) =>
      builder.append(t).append(separator)
    case HyperLink(text,url) =>
      builder.append(s"<a href='${url}'>$text</a>").append(separator)
  }

  def textExportVisitor(builder: StringBuilder):Element => Unit = {
    case Title(t) =>
      builder.append(t).append(separator)
    case Text(t) =>
      builder.append(t).append(separator)
    case HyperLink(text, url) =>
      builder.append(s"$text - $url").append(separator)
  }

  def main(args: Array[String]): Unit = {
    val document = new Document(List(
      Title("scala style pattern"),
      Text("the visitor patterns helps us add extra functionality with out changing the classes"),
      HyperLink("scala", "http://www.lightbend.com/"),
      Text("Thanks")
    ))


    val html = new StringBuilder
    println("export html:")
    document.accept(htmlExportVisitor(html))
    println(html.toString())


    val text = new StringBuilder
    println("export text")
    document.accept(textExportVisitor(text))
    println(text.toString())
  }

}