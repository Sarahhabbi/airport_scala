import CSVParser.readCSV
import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

/*object PrivateExecutionContext {
  val executors = Executors.newFixedThreadPool(4)
  implicit val ec : ExecutionContext = ExecutionContext.fromExecutorService(executors)
}*/
object Main {
/*  import slick.jdbc.PostgresProfile.api._
  import PrivateExecutionContext._

  val airportTest = Airport("6523","00A","heliport","Total Rf Heliport","40.07080078125","-74.93360137939453","11","NA","US","US-PA","Bensalem","no","00A","1","00A","1","1","1")

  def insertAirport(): Unit = {
    val queryDescription = SlickTables.airportTable += airportTest
    val futureId : Future[Int] = Connection.db.run(queryDescription)

    futureId.onComplete{
      case Success(newAirportId) => println(s"Query was successfull, new id is $newAirportId")
      case Failure(ex) => println(s"Query failed, reason $ex")
    }
    Thread.sleep(10000)
  }*/
}
