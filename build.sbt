enablePlugins(JavaServerAppPackaging)

enablePlugins(DockerPlugin)

name := """sdkman-website"""

organization := "io.sdkman"

Docker / packageName := "sdkman/sdkman-website"

dockerBaseImage := "openjdk:11"

dockerExposedPorts ++= Seq(9000)

Universal / javaOptions ++= Seq(
  "-Dpidfile.path=/dev/null"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.13"

resolvers ++= Seq(
  Resolver.mavenCentral,
  "jitpack" at "https://jitpack.io"
)

libraryDependencies ++= Seq(
  ws,
  guice,
  caffeine,
  "com.github.sdkman" % "sdkman-mongodb-persistence" % "2.4",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.3",
  "com.iheart" %% "ficus" % "1.5.0"
)

import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  ReleaseStep(releaseStepTask(publish in Docker)),
  setNextVersion,
  commitNextVersion,
  pushChanges
)
