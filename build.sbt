name := """study-scala"""

version := "1.0"

scalaVersion := "2.11.8"

fork in run := true

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
//libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.6" % "test"
//libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.4"
