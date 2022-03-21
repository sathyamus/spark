# Spark-shell

 -- kerberos authentication 
    $ klist
    $ kdestroy
    $ kinit

# Spark job memory tuning

-> For kyro serialization, default value is at 64 MB, updated to 512MB

-> MIN_EXECUTORS = 2
-> MAX_EXECUTORS = 4
-> SPARK_CORE = 1  // remain it same
-> DRIVER_MEMORY = 15G

-> JVM_MAX_MEMORY = 16G
-> JVM_MIN_MEMORY = 8G


# Running Java Applications through spark

  - Generate huge thread dumps and export those stats to analyze.
  - Use Flame graph to analyze those stats
  - Identify the memory, usage consumptions


# SparkSession
 
  - Need a Spark Session for each set of tests, in this way, the results of these tests will not affect others that will also require a Spark Session.
  - Before, After each test we need to initialize and cleanup the session accordingly.

 - https://www.jetbrains.com/help/idea/discover-intellij-idea-for-scala.html#UserInterface
 - https://www.jetbrains.com/help/idea/run-debug-and-test-scala.html

 - https://www.scala-sbt.org/1.x/docs/sbt-by-example.html
 - https://repository.apache.org/#nexus-search;quick~spark-core
 
 - https://spark.apache.org/docs/latest/building-spark.html
 - https://github.com/martinprobson/Spark-Scala-Maven-Example/blob/master/pom.xml
 - https://github.com/MrPowers/spark-fast-tests/commit/d8207c5cdb3a6c4d03adae8b9a571d3f506baffc
 - https://mrpowers.medium.com/creating-a-java-spark-project-with-maven-and-junit-614e8be96c3f

