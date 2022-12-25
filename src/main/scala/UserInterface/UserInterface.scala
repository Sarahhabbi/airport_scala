package UserInterface;
import scala.annotation.tailrec

object UserInterface {

  /* TODO: move to a service*/
  def searchCountryAirportsAndRunways(country: String, byCode: Boolean): Unit = {
    if(byCode){
      /* select from code column */
      println(s"You choose to browse by country code : $country")
    }
    else{
      /* select from name column */
      println("You choose to browse by country name : $country")
    }
    /* display select result */
    println("will display result of query")
  }

  /* QUERY OPTION */
  def showCountry(byCode: Boolean = false): Unit = {
    println("Enter the country code")
    val country = scala.io.StdIn.readLine()
    searchCountryAirportsAndRunways(country, byCode)
  }

  def displayQueryOptions(errorMessage: String = ""): Unit = {
    if(errorMessage != ""){
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
      case "2.1" => showTop10Countries()/* QUERY */
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
    if(errorMessage != ""){
      println(errorMessage)
    }

    println("You can browse through airports and runways via two options: ")
    println("0 - Exit app")
    println("1.1 - by country ISO code)")
    println("1.2 - by country name")
    val cmd = scala.io.StdIn.readLine()
    cmd match {
      case "0" => None /* EXIT APP*/
      case "1.1" => showCountry(byCode=true)/* QUERY */
      case "1.2" => showCountry()
      case "_" => printMenu("ERROR: Your choice is not valid !")
    }
    printMenu()
  }

  @tailrec
  def printMenu(errorMessage: String = ""): Unit = {
    if(errorMessage != ""){
      println(errorMessage)
    }

    println("Choose an option as below: ")
    println("0 - Exit app")
    println("1 - Query")
    println("2 - Report")
    val cmd = scala.io.StdIn.readLine()
    cmd match {
      case "0" => None /* EXIT APP*/
      case "1" => displayQueryOptions()/* QUERY */
      case "2" => displayReportOption()
      case "_" => printMenu("ERROR: Your choice is not valid !")
    }
  }

  def main(args: Array[String]): Unit = {
    printMenu()
  }
}


