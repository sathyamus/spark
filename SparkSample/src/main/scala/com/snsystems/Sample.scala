package com.snsystems

import org.apache.spark.sql.types.{ StringType, StructField, StructType }
import org.apache.spark.sql.{ DataFrame, Row, SparkSession }

object Sample {

  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder().master("local[1]").appName("SparkByExample").getOrCreate()

    import spark.implicits._

    val columns = Seq("language", "users_count")

    val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))

    val rdd = spark.sparkContext.parallelize(data)

    //From RDD (USING toDF())
    val dfFromRDD1 = rdd.toDF("language", "users")

    //From Data (USING toDF())
    val dfFromData1 = data.toDF()

    dfFromData1.show()

    //From RDD (USING createDataFrame)
    val dfFromRDD2 = spark.createDataFrame(rdd).toDF(columns: _*)

    //From Data (USING createDataFrame)
    var dfFromData2 = spark.createDataFrame(data).toDF(columns: _*)

    dfFromData2.show()
    //From RDD (USING createDataFrame and Adding schema using StructType)
    //convert RDD[T] to RDD[Row]

    val schema = StructType(columns.map(fieldName => StructField(fieldName, StringType, nullable = true)))

    val rowRDD = rdd.map(attributes => Row(attributes._1, attributes._2))

    val dfFromRDD3 = spark.createDataFrame(rowRDD, schema)

    dfFromRDD3.show()

    //From Data (USING createDataFrame and Adding schema using StructType)
    import scala.collection.JavaConversions._

    val rowData = data.map(attributes => Row(attributes._1, attributes._2))

    var dfFromData3 = spark.createDataFrame(rowData, schema)

    dfFromData3.show()
    //From Data (USING createDataFrame and Adding bean class)

  }
  
}