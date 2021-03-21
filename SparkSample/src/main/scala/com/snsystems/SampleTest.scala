package com.snsystems

import org.apache.spark.sql.SparkSession

object SampleTest {
  
  
  def  main(args: Array[String]): Unit = {
    
     val spark = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExample")
      .getOrCreate();

    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")
    
    val rdd = Seq(1,2,3)
    rdd.foreach(println)
    
    val rdd1 = sc.textFile("gb.txt");  // file///gb
   
    val rdd2 = rdd1.flatMap(f=>f.split(" "))
    
    rdd2.foreach(f=>println(f))
    
    val rdd3= rdd2.map(m=>(m,1))
    rdd3.foreach(println)
    
     val rdd4 = rdd3.filter(a=> a._1.startsWith("a"))
    rdd4.foreach(println)
    
     val rdd5 = rdd4.reduceByKey(_ + _)
   rdd5.foreach(println)
    
  }
  
}