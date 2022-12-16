import java.io.File
import scala.io.Source
import scala.io.Codec
import java.nio.charset.CodingErrorAction

object CSVParser {

    def readCSV(file_path: String): Unit = {
      val file = new File(file_path)
      val readBuffer = Source.fromFile(file)
      readBuffer
        .getLines()
        .foreach(line => println(line))
      readBuffer.close()
    }
}

