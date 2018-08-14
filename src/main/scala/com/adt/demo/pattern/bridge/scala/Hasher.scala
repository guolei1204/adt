package com.adt.demo.pattern.bridge.scala

import java.security.MessageDigest

trait Hasher {
  def hash(data:String):String

  protected def getDigest(algorithm:String ,data: String) :MessageDigest = {
    val crypt = MessageDigest.getInstance(algorithm)
    crypt.reset()
    crypt.update(data.getBytes("UTF-8"))
    crypt
  }
}


trait Sha1Hasher extends Hasher{
  override def hash(data: String): String = {
    getDigest("SHA-1",data).digest().map(_.byteValue().toHexString).mkString("")
  }
}

trait Sha256Hasher extends Hasher {
  override def hash(data: String): String = {
    getDigest("SHA-256", data).digest().map(_.byteValue().toHexString).mkString("")
  }
}
trait Md5Hasher extends Hasher{
  override def hash(data: String): String = {
    getDigest("MD5",data).digest().map(_.byteValue().toHexString).mkString("")
  }
}

abstract class PassWordConverter{
  self:Hasher =>

  def convert(password:String):String
}

class SimplePassWordConverter extends PassWordConverter{
  self:Hasher =>
  override def convert(password: String): String =  hash(password)
}

class SaltedPassWordConverter(salt:String) extends PassWordConverter{
  self:Hasher =>
  override def convert(password: String): String = hash(s"${salt}:${password}")
}

object Demo{
  def main(args: Array[String]): Unit = {
    val p1 = new SimplePassWordConverter with Md5Hasher
    val p2 = new SimplePassWordConverter with Sha256Hasher
    val salted = "miss"
    val p3 = new SaltedPassWordConverter(salted) with  Sha1Hasher
    val p4 = new SaltedPassWordConverter(salted) with Sha256Hasher
    val msg = "password"

    println(s"`password` in md5 is ${p1.convert(msg).toUpperCase}")
    println(s"`password` in sha-256 is ${p2.convert(msg).toUpperCase}")
    println(s"`password` with salt ${salted} in sha-1 is ${p3.convert(msg).toUpperCase()}")
    println(s"`password` with salt ${salted} in sha-256 is ${p4.convert(msg).toUpperCase()}")
  }
}