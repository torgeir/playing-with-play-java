import sbt._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "playing-with-play-java"
  val appVersion      = "1.0-SNAPSHOT"

  val depsApp = Seq(
    javaCore,
    javaJdbc,
    javaEbean
  )

  val depsCloudfoundry = Seq(
    javaJpa
    // lib/auto-reconfiguration-0.6.6.jar
    // lib/hibernate-jpa-2.0-api-1.0.1.Final.jar
  )

  val depsRedis = Seq(
    "redis.clients" % "jedis" % "2.1.0"
  )

  val deps =
    depsApp ++
    depsCloudfoundry ++
    depsRedis

  val main = play.Project(appName, appVersion, deps).settings(
    // Add your own project settings here

  )
}