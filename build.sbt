name:= "GenomeAnalytics"
version:= "1.0.0"
scalaVersion:= "2.11.8"

resolvers += "SparkJobServer" at "https://dl.bintray.com/spark-jobserver/maven"

libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-core" % "2.2.0" % "provided",
"org.apache.spark" %% "spark-sql" % "2.2.0" % "provided",
"org.postgresql" % "postgresql" % "9.3-1104-jdbc41",
"com.typesafe" % "config" % "1.3.0-M1",
"spark.jobserver" %% "job-server-api" % "0.8.0",
"spark.jobserver" %% "job-server-extras" % "0.8.0"
)