enablePlugins(JavaServerAppPackaging)

enablePlugins(DockerPlugin)

name := """sdkman-website"""

organization := "io.sdkman"

version := "0.41.0"

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
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test,
  "com.github.tomakehurst" % "wiremock" % "2.4.1" % Test,
  "org.jvnet.mock-javamail" % "mock-javamail" % "1.9" % Test,
  "org.scalaj" %% "scalaj-http" % "2.4.1" % Test)

libraryDependencies ++= Seq(
  ws,
  guice,
  "io.sdkman" %% "sdkman-mongodb-persistence" % "0.11",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "ch.lightshed" %% "courier" % "0.1.4")
