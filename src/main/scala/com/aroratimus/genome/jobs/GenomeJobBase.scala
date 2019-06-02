package com.aroratimus.genome.jobs

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import spark.jobserver.SparkJobInvalid
import spark.jobserver.SparkJobValid


/*
 * Helper object for running job from command line
 */
object GenomeJobBase {

  def runFromCommandLine(args: Array[String], job: GenomeBase, name: String) { 
    if (args.length == 0) {
      println("Configuration was not supplied")
      return
    }
    val config = ConfigFactory.parseString(args(0))

    val sparkConf = new SparkConf()
                                  .setAppName("Customer Genome" + name)
                                  //    .setIfMissing("spark.master", GenomeConfiguration.DEFAULT_SPARK_MASTER)
                                  .setIfMissing("spark.master", "local[4]")
                                  .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                                  .set("spark.streaming.filesStream.minRememberDuration", "60s")
                                  
     val ss = SparkSession.builder().appName("Customer Genome").config(sparkConf).getOrCreate()
     
     job.validate(ss.sparkContext, config) match{
      case SparkJobInvalid(reason) => {
        println("validation failed"+ reason)
      }
      
      case SparkJobValid => {
        job.runJob(ss.sparkContext,config)
      }
    }
    ss.sparkContext.stop()
  }
}

class GenomeJobBase {

}