trait Log {
  def info(msg: String)

  def warn(msg: String)

  def error(msg: String)

  def debug(msg: String)
}


class Logger {
  def log(message: String, level: String) = println(s"${level.toUpperCase}: $message")
}

class AppLogger extends Logger with Log {
  override def info(msg: String): Unit = log(msg, "info")

  override def warn(msg: String): Unit = log(msg, "warn")

  override def error(msg: String): Unit = log(msg, "error")

  override def debug(msg: String): Unit = log(msg, "debug")
}


final class FinalLogger {
  def log(msg: String, level: String) = {
    println(s"${level.toUpperCase} : $msg")
  }
}

final class FinalAppLogger extends Log {
  private val logger = new FinalLogger

  override def info(msg: String): Unit = logger.log(msg, "info")

  override def warn(msg: String): Unit = logger.log(msg, "warn")

  override def error(msg: String): Unit = logger.log(msg, "error")

  override def debug(msg: String): Unit = logger.log(msg, "msg")
}

implicit class FinalAppLoggerImplicit(logger: FinalLogger) extends Log {

  override def info(message: String): Unit =
    logger.log(message, "info")

  override def warn(message: String): Unit =
    logger.log(message, "warning")

  override def error(message: String): Unit =
    logger.log(message, "error")

  override def debug(message: String): Unit =
    logger.log(message, "debug")
}


val logger:Log = new AppLogger
logger.info("This is an info message.")
logger.debug("Debug something here.")
logger.error("Show an error message.")
logger.warn("About to finish.")
logger.info("Bye!")

print("#" * 99)
val logger1: Log = new FinalLogger
logger1.info("This is an info message.")
logger1.debug("Debug something here.")
logger1.error("Show an error message.")
logger1.warn("About to finish.")
logger1.info("Bye!")
