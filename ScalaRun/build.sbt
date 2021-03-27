name := "ScalaRun"

version := "0.1"

crossScalaVersions := Seq("2.12.12")
scalaVersion := crossScalaVersions.value.head

//scalaVersion := "2.12.13"

val sparkVersion = "3.0.1"

//idePackagePrefix := Some("com.snsystems")

libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

//resolvers ++= Seq(
//  "apache-snapshots" at "https://repository.apache.org/snapshots/"
//)

//libraryDependencies ++= Seq(
//  "org.apache.spark" %% "spark-core" % sparkVersion,
//  "org.apache.spark" %% "spark-sql" % sparkVersion,
//  "org.apache.spark" %% "spark-mllib" % sparkVersion,
//  "org.apache.spark" %% "spark-streaming" % sparkVersion,
//  "org.apache.spark" %% "spark-hive" % sparkVersion,
//  "mysql" % "mysql-connector-java" % "5.1.6"
//)

//libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
//libraryDependencies += "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided"
//libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

//libraryDependencies ++= Seq(
//
//  "com.typesafe" % "config" % "1.3.3"
//
//)
//
//libraryDependencies ++= Seq(
//
//  "org.apache.spark" % "spark-sql" % sparkVersion % "provided"
//
//)
//
//libraryDependencies ++= Seq(
//
//  "org.apache.spark" % "spark-core" % sparkVersion % "provided"
//
//)
