case class Airport(id: String, ident: String, airport_type: String, name: String, latitude_deg: String, longitude_deg: String, elevation_ft: String, continent: String, iso_country: String, iso_region: String, municipality: String, scheduled_service: String, gps_code: String, iata_code: String, local_code: String, home_link: String, wikipedia_link: String, keywords: String)

object SlickTables {
  import slick.jdbc.PostgresProfile.api._
  class AirportTable(tag: Tag) extends Table[Airport] (tag, Some("airports"), "Airport") {
     def id = column[String]("airport_id", O.PrimaryKey, O.AutoInc)

     def airport_type = column[String]("airport_type")

     def ident = column[String]("indent")

     def name = column[String]("name")

     def latitude_deg = column[String]("latitude_deg")

     def longitude_deg = column[String]("longitude_deg")

     def elevation_ft = column[String]("elevation_ft")

     def continent = column[String]("continent")

     def iso_country = column[String]("iso_country")

     def iso_region = column[String]("iso_region")

     def municipality = column[String]("municipality")

     def scheduled_service = column[String]("scheduled_service")

     def gps_code = column[String]("gps_code")

     def iata_code = column[String]("iata_code")

     def local_code = column[String]("local_code")

     def home_link = column[String]("home_link")

     def wikipedia_link = column[String]("wikipedia_link")

     def keywords = column[String]("keywords")

     override def * = (id, ident, airport_type, name, latitude_deg, longitude_deg, elevation_ft, continent, iso_country, iso_region, municipality, scheduled_service, gps_code, iata_code, local_code, home_link, wikipedia_link, keywords)<> (Airport.tupled, Airport.unapply)
   }
     //API entry point
  lazy val airportTable = TableQuery[AirportTable]
}
