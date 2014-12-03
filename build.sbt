name := "scala-parsers"

version := "0.2.1-1"

organization in Global := "oncue.ermine"

scalaVersion := "2.11.2"

crossScalaVersions := Seq("2.11.2", "2.10.4")

description := "A Trifecta inspired parser in Scala."

licenses += ("BSD Simplified", url("https://github.com/ermine-language/ermine-parser/blob/master/LICENSE"))

homepage := Some(url("https://github.com/ermine-language/ermine-parser"))

publishMavenStyle := true

scalacOptions ++=
  Seq("-encoding", "UTF-8", "-Yrecursion", "50", "-deprecation",
      "-unchecked", "-Xlint", "-feature",
      "-language:implicitConversions", "-language:higherKinds",
      "-language:existentials", "-language:postfixOps")

resolvers += "bintray/non" at "http://dl.bintray.com/non/maven"

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.5.2")

parallelExecution := true

javacOptions += "-Xlint"

val scalazVersion = "7.1.0"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test"
)

initialCommands in console := "import scalaz._, Scalaz._; import scalaparsers._"

publishTo <<= version.apply(v => {
  val nexus = "http://nexus.svc.oncue.com/nexus/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "content/repositories/thirdparty")
 })

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
