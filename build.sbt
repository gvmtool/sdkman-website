enablePlugins(JavaServerAppPackaging)

enablePlugins(DockerPlugin)

name := """sdkman-website"""

organization := "io.sdkman"

version := "0.55.0"

packageName in Docker := "sdkman/sdkman-website"

dockerExposedPorts ++= Seq(9000)

javaOptions in Universal ++= Seq(
  "-Dpidfile.path=/dev/null"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

resolvers ++= Seq(
  Resolver.bintrayRepo("sdkman", "maven"),
  Resolver.jcenterRepo
)

libraryDependencies ++= Seq(
  ws,
  guice,
  "io.sdkman" %% "sdkman-mongodb-persistence" % "1.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "com.iheart" %% "ficus" % "1.4.7")
