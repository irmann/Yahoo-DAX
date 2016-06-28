name := "hello"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "com.yahoofinance-api" % "YahooFinanceAPI" % "1.3.0"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"        % "2.3.+",
  "com.h2database"  %  "h2"                 % "1.4.+",
  "ch.qos.logback"  %  "logback-classic"    % "1.1.+"
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.16"
