import Model.{getCountryFromIso, getIsoFromCountry}

object Service {
  /* QUERY OPTION */
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

  /* REPORT OPTIONS*/
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
    val airportsData = Model.airports
    airportsData.foreach {

      case (isoCode, airportList) => {
        var runwayList: Set[String] = Set()
        val countryName = getCountryFromIso(isoCode)

        airportList.foreach (airport => {
          val airportRef = airport.id.toString
          val airportRunways = Model.runways.getOrElse(airportRef.slice(1, airportRef.length() - 1), null)
          if(airportRunways != null){
            airportRunways.foreach(airportRunway => {
              runwayList += airportRunway.surface
            })
          }
        })
        println(s"---> Type of runways for country : $countryName")
        println(s"$runwayList \n")
      }
    }
  }

  def showTop10RunwaysLatitude() = {
    val runwaysData = Model.runways
    var runwayLatitudeList: Seq[String] = Seq()

    runwaysData.foreach {

      case (airportRef, runwayList) => {
        runwayList.foreach (runway => {
          runwayLatitudeList = runwayLatitudeList :+ runway.le_ident
        })
      }
    }
    runwayLatitudeList.groupBy(l => l).map(t => (t._1, t._2.length)).toSeq.sortBy(t => t._2)
    val top1OLatitude = runwayLatitudeList.takeRight(10)
    println(s"The top 10 latitude are : $top1OLatitude \n")
  }
}