import scala.io.Source

case class Money(amount:Int)


trait  PartialFunctionDispenser {
  def dispense(dispenserAmount:Int): PartialFunction[Money,Money] = {
    case Money(amount) if amount >= dispenserAmount  =>
      val notes = amount / dispenserAmount
      val left = amount % dispenserAmount
      println(s"dispensing $notes note/s of $dispenserAmount")
      Money(left)
    case m @ Money(amount) => m
  }
}

class PartialFunctionATM extends PartialFunctionDispenser {
  val dispenser =
    dispense(50)
      .andThen(dispense(20))
      .andThen(dispense(10))
      .andThen(dispense(5))

  def requestMoney(money: Money):Unit = {
    if (money.amount % 5 != 0){
      println("The smallest is 5 and we can not satisfy your request")
    }else{
      dispenser(money)
    }
  }
}

object ATMExample{
  final val atm = new PartialFunctionATM()
  def printHelp() = {
    println(
      """
        |Usage:
        |  1. Write an amount
        |  2. write exit to quit
      """.stripMargin)
  }

  def processLine(line: String)  = line match{
    case "exit" =>
      println("Bye")
      System.exit(0)
    case l =>
      try{
        atm.requestMoney(Money(l.toLong.toInt))
      }catch {
        case _:Throwable =>
          println(s"invalide intput :$l")
          printHelp()
      }
  }

  def main(args: Array[String]): Unit = {
    Source.stdin.getLines().foreach{
      case line =>
        processLine(line)
    }
  }
}