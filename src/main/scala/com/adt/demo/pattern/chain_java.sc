import scala.io.Source

case class Money(amount: Long)

trait  Dispenser{
  val amount:Long
  val next: Option[Dispenser]

  def dispense(money: Money) : Unit = {
    if(money.amount >= amount){
      val notes = money.amount / amount
      val left = money.amount % amount
      println(s"dispense $notes note/s of $amount")
      if (left > 0){
        next.map(_.dispense(Money(left.toInt)))
      }
    } else {
      next.foreach(_.dispense(money))
    }
  }
}

class Dispenser50(val next:Option[Dispenser]) extends Dispenser{
  override val amount = 50L
}

class Dispenser20(val next: Option[Dispenser]) extends Dispenser {
  override val amount = 20L
}

class Dispenser10(val next: Option[Dispenser]) extends Dispenser {
  override val amount = 10L
}

class Dispenser5(val next: Option[Dispenser]) extends Dispenser {
  override val amount = 5L
}

class  ATM {
  import  ATM.dispensers
  def requestMoney(money: Money) = {
    if (money.amount%5 != 0){
      throw new Exception("The smallest nominal")
    }else{
      dispensers.dispense(money)
    }
  }
}
object ATM{
  private final val dispensers = {
    new Dispenser50(Some(new Dispenser20(Some(new Dispenser10(Some(new Dispenser5(None)))))))
  }
}

object ATMDemo{
  val atm = new ATM

  def printHelp() = {
    println(
      """
        |Usage:
        |  1. Write an amount
        |  2. write exit to quit
      """.stripMargin)
  }

  def processLine(line: String) = line match {
    case "exit" =>
      println("Bye")
      System.exit(0)
    case l =>
      try {
        atm.requestMoney(Money(l.toLong.toInt))
      } catch {
        case _: Throwable =>
          println(s"invalide intput :$l")
          printHelp()
      }
  }

  def main(args: Array[String]): Unit = {
    Source.stdin.getLines().foreach {
      case line =>
        processLine(line)
    }
  }
}