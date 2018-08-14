import scala.collection.mutable.ListBuffer

trait RobotCommand{
  def execute():Unit
}

case class Robot(){
  def cleanUp() = println("clean up ...")
  def pourJuice()  = println("pour juice ...")
  def makeSandwich() = println("make sandwich ...")
}

case class MakeSandwichCommand(robot:Robot) extends  RobotCommand{
  override def execute(): Unit = robot.makeSandwich()
}

case class PourJuiceCommand(robot: Robot) extends RobotCommand{
  override def execute(): Unit = robot.pourJuice()
}

case class CleanUpCommand(robot: Robot) extends RobotCommand{
  override def execute(): Unit = robot.cleanUp()
}


class RobotController {
  val history = ListBuffer[RobotCommand]()

  def issueCommand(command: RobotCommand) = {
    command +=: history
    command.execute()
  }

  def showHistory() = {
    history.foreach(println)
  }
}

class RobotByNameController{
  val history = ListBuffer[() => Unit]()

  def issueCommand(command: => Unit):Unit = {
    command _ +=: history // convert method to function
    command
  }
  def showHistory() = {
    history.foreach(it => it())
  }
}


object RobotExample{
  def main(args: Array[String]): Unit = {
    val robot = Robot()
    val controller = new RobotController
    controller.issueCommand(MakeSandwichCommand(robot))
    controller.issueCommand(PourJuiceCommand(robot))
    println("eating sandwich and drinking juice")
    controller.issueCommand(CleanUpCommand(robot))
    println("ask robot clean table")
    controller.showHistory()

    val nameController = new RobotByNameController
    nameController.issueCommand(MakeSandwichCommand(robot).execute())
    nameController.issueCommand(PourJuiceCommand(robot).execute())
    nameController.issueCommand(CleanUpCommand(robot).execute())
    println("name controller show history :")
    nameController.showHistory()
  }
}

