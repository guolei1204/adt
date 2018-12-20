name := "adt"


version := "1.0"

scalaVersion := "2.12.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.20"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1"

libraryDependencies ++= Seq(
  "org.freemarker" % "freemarker" % "2.3.23",
  "org.xhtmlrenderer" % "flying-saucer-core" % "9.0.8",
  "org.xhtmlrenderer" % "flying-saucer-pdf" % "9.0.8",
  "org.xhtmlrenderer" % "flying-saucer-pdf-itext5" % "9.0.8",
  "com.alibaba" % "fastjson" % "1.2.51",
  "junit" % "junit" % "4.12" % Test
)
