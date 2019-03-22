package com.adt.demo.xml.joom

import org.jooq.codegen.GenerationTool

object GenFromXml {
  def main(args: Array[String]): Unit = {
    GenerationTool.main(Array.apply("/Users/guolei/fun/adt/src/main/scala/com/adt/demo/xml/library.xml"))
  }
}
