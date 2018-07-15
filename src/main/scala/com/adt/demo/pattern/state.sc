trait State[T]{
  def press(context: T)
}

class Playing extends State[MediaPlayer]{
  override def press(context: MediaPlayer): Unit = {
    println("pressing pause")
    context.setState(new Paused)
  }
}

class Paused extends State[MediaPlayer]{
  override def press(context: MediaPlayer): Unit ={
    println("pressing play")
    context.setState(new Playing)
  }
}


case class MediaPlayer(){
  private var state:State[MediaPlayer] = new Paused

  def pressPlayOrPauseBotton()  = {
    println("pressing button")
    state.press(this)
  }

  def setState(state: State[MediaPlayer]) = {
    this.state = state
  }
}


object  MediaPlayerDemo {
  def main(args: Array[String]): Unit = {
    val player = MediaPlayer()
    player.pressPlayOrPauseBotton()
    player.pressPlayOrPauseBotton()
    player.pressPlayOrPauseBotton()
    player.pressPlayOrPauseBotton()
    player.pressPlayOrPauseBotton()
    player.pressPlayOrPauseBotton()
  }
}