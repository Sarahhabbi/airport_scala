import Model.{airports, getCountryFromIso, getIsoFromCountry, iso_countries, loadAirports, loadCountries, loadRunways, runways}

import scala.annotation.tailrec

object UserInterface {

  def searchCountryAirportsRunways(country: String, byCode: Boolean): Unit = {
    println(s"Results for $country")
    var iso_country = country
    if (!byCode) {
       iso_country = getIsoFromCountry(country)
    }

    val selected_airports = Model.airports.getOrElse(iso_country, null)
    selected_airports.foreach(airport => {
      println(s"---> $airport \n")
      val airportRef = airport.id.toString
      val airportRunways = Model.runways.getOrElse(airportRef.slice(1, airportRef.length() - 1), null)
      if(airportRunways!=null){
        airportRunways.foreach(airportRunway => {
          println(s"  >> $airportRunway \n")
        })
      }
    })
  }

  /* QUERY OPTION */
  def showCountry(byCode: Boolean = false): Unit = {
    if(byCode){
      println("Enter the country code")
    }
    else{
      println("Enter the country name")
    }
    val country = scala.io.StdIn.readLine()
    searchCountryAirportsRunways(country, byCode)
  }

  def displayReportOptions(errorMessage: String = ""): Unit = {
    if (errorMessage != "") {
      println(errorMessage)
    }

    println("Choose an option: ")
    println("0 - Exit app")
    println("2.1 - 10 countries with highest number of airports and countries  with lowest number of airports.")
    println("2.2 - Type of runways per country")
    println("2.3 - The top 10 most common runway latitude")
    val cmd = scala.io.StdIn.readLine()
    cmd match {
      case "0" => None /* EXIT APP*/
      case "2.1" => showTop10Countries() /* QUERY */
      case "2.2" => showTypeRunways()
      case "2.3" => showTop10RunwaysLatitude()
      case "_" => printMenu("ERROR: Your choice is not valid !")
    }
    printMenu()
  }

  /* REPORT OPTION */
  def showTop10Countries() = {
    val sortedAirports = Model.airports.toSeq.sortBy(_._2.length)
    val lowest = sortedAirports.filter(_._2.length == 1)
    println(s"Countries with lowest number of airports")
    lowest.foreach(airport => {
      val iso_code = airport._1
      val country = getCountryFromIso(iso_code)
      val count = airport._2.length
      println(s"---> $country: $count")
    })

    val top10Highest = sortedAirports.takeRight(10)
    println(s"TOP 10 countries with highest number of airports")
    top10Highest.foreach(airport => {
      val iso_code = airport._1
      val country = getCountryFromIso(iso_code)
      val count = airport._2.length
      println(s"---> $country: $count")
    })

  }

  def showTypeRunways() = {
    /* TODO: showTypeRunways*/
  }

  def showTop10RunwaysLatitude() = {
    /* TODO:showTop10RunwaysLatitude */
  }

  def displayQueryOptions(errorMessage: String = ""): Unit = {
    if (errorMessage != "") {
      println(errorMessage)
    }

    println("You can browse through airports and runways via two options: ")
    println("0 - Exit app")
    println("1.1 - by country ISO code)")
    println("1.2 - by country name")
    val cmd = scala.io.StdIn.readLine()
    cmd match {
      case "0" => None /* EXIT APP*/
      case "1.1" => showCountry(byCode = true) /* QUERY */
      case "1.2" => showCountry()
      case "_" => printMenu("ERROR: Your choice is not valid !")
    }
    printMenu()
  }

  @tailrec
  def printMenu(errorMessage: String = ""): Unit = {
    if (errorMessage != "") {
      println(errorMessage)
    }

    println("Choose an option as below: ")
    println("0 - Exit app")
    println("1 - Query")
    println("2 - Report")
    val cmd = scala.io.StdIn.readLine()
    cmd match {
      case "0" => None /* EXIT APP*/
      case "1" => displayQueryOptions() /* QUERY */
      case "2" => displayReportOptions()
      case "_" => printMenu("ERROR: Your choice is not valid !")
    }
  }

  def main(args: Array[String]): Unit = {
    loadCountries()
    loadAirports()
    loadRunways()
    printMenu()
    println(iso_countries)
  }
}
