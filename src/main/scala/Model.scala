import java.io.File
import scala.io.Source
import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer

object Model {
  case class Airport(id: Integer, ident: String, airport_type: String, name: String, latitude_deg: String, longitude_deg: String, elevation_ft: String, continent: String, iso_country: String, iso_region: String, municipality: String, scheduled_service: String, gps_code: String, iata_code: String, local_code: String, home_link: String, wikipedia_link: String, keywords: String)
  case class Country(id: Integer, code: String, name: String, continent : String, wikipedia_link: String, keywords: String)
  case class Runway(id: Integer, airport_ref: String, airport_ident: String, length_ft: String, width_ft: String, surface: String, lighted: String, closed: String, le_ident: String, le_latitude_deg: String, le_longitude_deg: String, le_elevation_ft: String, le_heading_degT: String, le_displaced_threshold_ft: String, he_ident: String, he_latitude_deg: String, he_longitude_deg: String, he_elevation_ft: String, he_heading_degT: String, he_displaced_threshold_ft: String)

  var airports:HashMap[String, ListBuffer[Airport]]  = new HashMap()
  var countries:HashMap[String, Country] = new HashMap()
  var iso_countries:HashMap[String, Country] = new HashMap()
  var runways:HashMap[String, ListBuffer[Runway]] = new HashMap()

  def loadCountries(): Unit ={
    val file = new File("./src/data/countries.csv")
    val readBuffer = Source.fromFile(file)
    readBuffer
      .getLines()
      .drop(1)
      .foreach(line => {
        val cols = line.split(",").map(_.trim)
        countries.put(cols(2), Country(cols(0).toInt, cols(1), cols(2), cols(3), cols(4), " "))
        iso_countries.put(cols(1), Country(cols(0).toInt, cols(1), cols(2), cols(3), cols(4), " "))
      })
    readBuffer.close()
  }

  def loadAirports(): Unit ={
    val file = new File("./src/data/airports.csv")
    val readBuffer = Source.fromFile(file)
    readBuffer
      .getLines()
      .drop(1)
      .foreach(line => {
        val cols = line.split(",").map(_.trim)
        airports(cols(2)) += Airport(cols(0).toInt, cols(1), cols(2), cols(3), cols(4), cols(5), cols(6), cols(7), cols(8), cols(9), cols(10), cols(11), cols(12), cols(13), cols(14), cols(15), cols(16), cols(17))
      })
    readBuffer.close()
  }
}

