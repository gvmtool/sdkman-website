enablePlugins(JavaServerAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(GitVersioning)

name := """sdkman-website"""

organization := "io.sdkman"

git.formattedShaVersion := git.gitHeadCommit.value.map(_.take(7))

Docker / packageName := "registry.digitalocean.com/sdkman/sdkman-website"

dockerUpdateLatest := true

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

