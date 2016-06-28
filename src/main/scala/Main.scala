import java.util.{ Date, Locale }
import java.text.DateFormat
import java.text.DateFormat._
import yahoofinance.{Stock,YahooFinance}
import yahoofinance.histquotes.{Interval,HistoricalQuote}
import java.util.Calendar
import scalikejdbc._

import scala.language.implicitConversions
import scala.collection.convert.WrapAsScala.enumerationAsScalaIterator

import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {

  GlobalSettings.loggingSQLAndTime = new LoggingSQLAndTimeSettings(
    enabled = false,
    singleLineMode = false,
    logLevel = 'ERROR
  )


  for(line <- Source.fromFile("symbole_list.txt").getLines()){
    var ticket = line

    var from = Calendar.getInstance()
    from.add(Calendar.YEAR,-5)
    var to = Calendar getInstance
    var stock = YahooFinance.get(ticket, from, to, Interval.DAILY)
    Class.forName("com.mysql.jdbc.Driver")
    ConnectionPool.singleton("jdbc:mysql://localhost/testdb", "root", "root")
    implicit val session = AutoSession
     for (history <- stock.getHistory().toArray()){
        var s: yahoofinance.histquotes.HistoricalQuote = history.asInstanceOf[yahoofinance.histquotes.HistoricalQuote]
        var symbol = s.getSymbol()
        var close= s.getClose()
        var high= s.getHigh()
        var low= s.getLow()
        var open= s.getOpen()
        var volume= s.getVolume()
        var gregorianCalendar: java.util.GregorianCalendar = s.getDate().asInstanceOf[java.util.GregorianCalendar]
        var date = gregorianCalendar.getTime()
       sql"insert into history(symbol,open,high,low,close,volume,date) values($symbol,$open,$high,$low,$close,$volume,$date)".update.apply();
     }

     }
  }
}
