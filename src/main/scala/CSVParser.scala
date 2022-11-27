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

    def main(args: Array[String]): Unit = {
      implicit val codec = Codec("UTF-8")
      codec.onMalformedInput(CodingErrorAction.REPLACE)
      codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

      val filename = io.Source.fromFile("./src/data/countries.csv").getLines()
      filename foreach {x => filename.foreach(println)}
    }
}

