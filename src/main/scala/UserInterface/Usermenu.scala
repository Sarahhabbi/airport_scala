package UserInterface;
import scala.swing._


object Usermenu {
  def main(args: Array[String]): Unit = {
    val frame = new MainFrame {
      title = "GUI"
      size = new Dimension(500, 500)
      centerOnScreen
    }
    frame.visible = true
  }
}
