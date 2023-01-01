import Model.{getIsoFromCountry, loadAirports, loadCountries}

import scala.annotation.tailrec

object UserInterface {

  def searchCountryAirports(country: String, byCode: Boolean): Unit = {
    println(s"Results for $country")
    if (byCode) {
      /* select from code column */
      println(s"Results for $country")
      val selected_airports = Model.airports.getOrElse(country, null)
      selected_airports.foreach(airport => {
        println(s"---> $airport \n")
      })
    }
    else {
      val iso_country = getIsoFromCountry(country)
      val selected_airports = Model.airports.getOrElse(iso_country, null)
      selected_airports.foreach(airport => {
        println(s"---> $airport \n")
      })
    }
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
    searchCountryAirports(country, byCode)
  }

  def displayQueryOptions(errorMessage: String = ""): Unit = {
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
    /* TODO:showTop10Countries */
  }

  def showTypeRunways() = {
    /* TODO: showTypeRunways*/
  }

  def showTop10RunwaysLatitude() = {
    /* TODO:showTop10RunwaysLatitude */
  }

  def displayReportOption(errorMessage: String = ""): Unit = {
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
      case "2" => displayReportOption()
      case "_" => printMenu("ERROR: Your choice is not valid !")
    }
  }

  def main(args: Array[String]): Unit = {
    loadCountries()
    loadAirports()
    printMenu()
  }
}
