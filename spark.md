# Spark-shell

 -- kerberos authentication  \
    $ klist \
    $ kdestroy \
    $ kinit

# Spark job memory tuning

-> For kyro serialization, default value is at 64 MB, updated to 512MB

-> MIN_EXECUTORS = 2 \
-> MAX_EXECUTORS = 4 \
-> SPARK_CORE = 1  // remain it same \
-> DRIVER_MEMORY = 15G

-> JVM_MAX_MEMORY = 16G \
-> JVM_MIN_MEMORY = 8G


# Running Java Applications through spark

  - Generate huge thread dumps and export those stats to analyze
  - Use Flame graph to analyze those stats
  - Identify the memory, usage consumptions


# SparkSession
 
  - Need a Spark Session for each set of tests, in this way, the results of these tests will not affect others that will also require a Spark Session.
  - Before, After each test we need to initialize and cleanup the session accordingly.

### RDD Operations
  - Transformations
    - Are lazy
    - Are computed only when an action requres a result to be returned
  - Actions
    - reduce, collect, count, first, take, foreach
  - Repartition 
    - To increase / decrease the number of partitions
  - Coalesce
    - To only decrease the number of partitions. This is optimized or improved version of repartition(), where movement of the data across the partitions is lower using coalesce.
  
### Launching Spark on YARN

  - --deploy-mode
  - In cluster mode, the Spark driver runs inside an application master process which is managed by YARN on the cluster, and the client can go away after initiating the application.
  - In client mode, the driver runs in the client process, and the application master is only used for requesting resources from YARN.

### Adding Other JARs
  - --jars
  - In cluster mode, the driver runs on a different machine than the client, so SparkContext.addJar won't work out of the box with files that are local to the client.


### Submitting Applications
  - --master
  - --deploy-mode
  - --executor-memory
  - The spark-submit script can load default Spark configuration values from a properties file and pass them on to your application. 
  - By default, it will read options from conf/spark-defaults.conf in the Spark directory.

### Spark Integration Test errors
  - Spark Task not serializable
    - If any stream / object is not serialized, we may endup facing this error.
    - Solution : Either change it to serialized type / use transient.

### Spark speeds up test runtime
    lazy val spark: SparkSession = {
      SparkSession
      .builder()
      .master("local")
      .appName("spark session")
      .config("spark.sql.shuffle.partitions", "1")
      .getOrCreate()
    }

### Spark History
   - Access the Spark History page from Ambari to view the Jobs, Stages and detailed view of spark job steps.

### Logs extraction
   - Event Logs
     - Ambari services -> 'Spark2' -> 'Spark2 History Server UI'
     - Click on respective 'App ID', Download button for Event Logs
     - https://docs.microsoft.com/en-us/azure/hdinsight/spark/apache-azure-spark-history-server
   - Node manager logs
     - Connect to worker node, with the location /var/log/hadoop-yarn/yarn

#### Issues
   - shell / terminal, kerberos authentication session will expire, after session idle time
     - Attempt re-login, before performing any actions like pushing manual messages to kafka / hdfs commands etc
     - This will avoid 4xx client auth errors
   - Container from Bad node
   - ADSL Gen2 Storage account Latency Issues
   - Kerberos Authentication Issues

 - https://www.jetbrains.com/help/idea/discover-intellij-idea-for-scala.html#UserInterface
 - https://www.jetbrains.com/help/idea/run-debug-and-test-scala.html

 - https://www.scala-sbt.org/1.x/docs/sbt-by-example.html
 - https://repository.apache.org/#nexus-search;quick~spark-core
 
 - https://spark.apache.org/docs/latest/building-spark.html
 - https://spark.apache.org/docs/latest/submitting-applications.html
 - https://spark.apache.org/docs/latest/running-on-yarn.html#launching-spark-on-yarn 
 - https://spark.apache.org/docs/latest/configuration.html

 - https://github.com/martinprobson/Spark-Scala-Maven-Example/blob/master/pom.xml
 - https://github.com/MrPowers/spark-fast-tests/commit/d8207c5cdb3a6c4d03adae8b9a571d3f506baffc
 - https://mrpowers.medium.com/creating-a-java-spark-project-with-maven-and-junit-614e8be96c3f

 - https://dev.to/adevintaspain/spark-unit-integration-and-end-to-end-tests-f52
 - https://github.com/holdenk/spark-testing-base
 - local[4] -- try with multi cores
 - https://www.reddit.com/r/apachespark/comments/bo4x12/figured_out_a_configuration_option_that_speeds_up/
 - https://sparkbyexamples.com/spark/spark-performance-tuning/
 - https://sparkbyexamples.com/spark/spark-dataframe-cache-and-persist-explained/