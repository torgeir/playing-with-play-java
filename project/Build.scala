import sbt._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "playing-with-play-java"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean
  )

  val cloudfoundryDependencies = Seq(
    javaJpa
    // lib/auto-reconfiguration-0.6.6.jar
    // lib/hibernate-jpa-2.0-api-1.0.1.Final.jar
  )

  val dependencies = appDependencies ++ cloudfoundryDependencies

  val main = play.Project(appName, appVersion, dependencies).settings(
    // Add your own project settings here
  )

}
