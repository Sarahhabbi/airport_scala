import Model.{countries, loadCountries}

object Main {
  def main(args: Array[String]): Unit = {
    loadCountries()
    println(countries)
    println(countries.get("pakistan"))
  }
}
