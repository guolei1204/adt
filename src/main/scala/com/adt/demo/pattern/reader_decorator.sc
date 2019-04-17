import java.io._
import java.nio.charset.Charset
import java.util.Base64
import java.util.zip.GZIPOutputStream

import scala.collection.JavaConverters._

trait  InputReader{
  def readLines(): Stream[String]
}

class AdvancedInputReader(reader:BufferedReader) extends  InputReader{
  override def readLines() = reader.lines().iterator().asScala.toStream
}

abstract  class InputReaderDecorator(inputReader: InputReader) extends InputReader{
  override def readLines(): Stream[String] = inputReader.readLines()
}

class CapitalizedInputReader(inputReader: InputReader) extends  InputReaderDecorator(inputReader){
  override def readLines() = super.readLines().map(_.toUpperCase)
}

class CompressInputReader(inputReader: InputReader) extends InputReaderDecorator(inputReader){
  override def readLines() = super.readLines().map{
    case line =>
      val text = line.getBytes(Charset.forName("utf-8"))
      val output = new ByteArrayOutputStream()
      val compressor = new GZIPOutputStream(output)
      try {
        compressor.write(text,0,text.length)
        new String(output.toByteArray,Charset.forName("utf-8"))
      }finally {
        compressor.close()
        output.close()
      }
  }
}

class Base64InputReader(inputReader: InputReader) extends InputReaderDecorator(inputReader){
  override def readLines() = super.readLines().map{case line =>
    Base64.getEncoder.encodeToString(line.getBytes(Charset.forName("utf-8")))
  }
}

object Demo{
  def main(args: Array[String]): Unit = {
    val stream = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/guolei/vagrant/spring.txt"))))
    try {
      val reader = new Base64InputReader(new CapitalizedInputReader(new AdvancedInputReader(stream)))
      reader.readLines().foreach(println)
    } finally {
      stream.close()
    }
  }

}