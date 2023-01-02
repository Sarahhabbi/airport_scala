import Model.{getCountryFromIso, getIsoFromCountry}

object Service {
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
    /*
    * FOR EACH AIRPORT
    *   CREATE AN EMPTY SET
    *   GET RUNWAYS FROM THIS AIRPORT ID
    *   FOR EACH RUNWAY
    *     ADD TO THE SET THE SURFACE TYPE
    *   DISPLAY COUNTRY + SET
    * */
  }

  def showTop10RunwaysLatitude() = {
    /* TODO:showTop10RunwaysLatitude */

    /*
    * FOR EACH RUNWAY
    *   GET LATITUDE AND ADD TO A MAP
    * GROUP BY LATITUDE AND COUNT
    *
    * SORT DESCENDANT ON COUNT
    * TAKE 10 first elements
    * */
  }

}
