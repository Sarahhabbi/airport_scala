import scala.io.Source
import java.io.File


class Main extends App {
  val countries = "./src/main/data/countries.csv"
  val airports = "./src/main/data/airports.csv"
  val runways = "./src/main/data/runways.csv"

  def readCSV(file_path: String): Unit = {
    val file = new File(file_path)
    val readBuffer = Source.fromFile(file)
    readBuffer
      .getLines()
      .foreach(line => println(line))
    readBuffer.close()
  }
  readCSV(countries)
  // readCSV(airports)
  // readCSV(runways)

}
