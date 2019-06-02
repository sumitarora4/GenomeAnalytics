package com.aroratimus.genome.jobs

import org.apache.spark.sql.functions._



object StoreCustomerScoreJobLauncher {

  def main(args: Array[String]) = {
		  GenomeJob.runFromCommanLine(args, new StoreCustomerScoreJob, "Store Customer Trait Score")
  }
}

class StoreCustomerScoreJob {

}