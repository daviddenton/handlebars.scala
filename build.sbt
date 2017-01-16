
val orgName = "io.github.daviddenton"

val projectName = "handlebars-scala-fork"

organization := orgName

name := projectName

description := "handlebars-scala maintenance fork"

scalaVersion := "2.12.0"

crossScalaVersions := Seq("2.12.0", "2.11.8")

scalacOptions += "-deprecation"

scalacOptions += "-feature"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.5",
  "org.slf4j" % "slf4j-api" % "1.6.4",
  "org.slf4j" % "slf4j-simple" % "1.6.4" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

licenses := Seq("BSD" -> url("http://www.opensource.org/licenses/bsd-license.php"))

pomExtra :=
  <url>http://{projectName}.github.io/</url>
    <scm>
      <url>git@github.com:daviddenton/{projectName}.scala.git</url>
      <connection>scm:git:git@github.com:daviddenton/{projectName}.scala.git</connection>
      <developerConnection>scm:git:git@github.com:daviddenton/{projectName}.scala.git</developerConnection>
    </scm>
    <developers>
      <developer>
        <name>David Denton (fork owner)</name>
        <email>dev@fintrospect.io</email>
        <organization>{projectName}</organization>
        <organizationUrl>http://daviddenton.github.io</organizationUrl>
      </developer>
      <developer>
        <id>mwunsch</id>
        <name>Mark Wunsch</name>
        <url>http://markwunsch.com/</url>
        <organization>Gilt</organization>
        <organizationUrl>http://www.gilt.com</organizationUrl>
      </developer>
      <developer>
        <id>chicks</id>
        <name>Chris Hicks</name>
        <url>http://tech.gilt.com/</url>
        <organization>Gilt</organization>
        <organizationUrl>http://www.gilt.com</organizationUrl>
      </developer>
      <developer>
        <id>timcharper</id>
        <name>Tim Harper</name>
        <url>http://timcharper.com/</url>
        <organization>Foundational Software</organization>
        <organizationUrl>http://www.foundationalsoftware.com</organizationUrl>
      </developer>    </developers>

credentials += Credentials(Path.userHome / ".sonatype" / ".credentials")

homepage := Some(url("https://github.com/mwunsch/handlebars.scala"))

Seq(bintraySettings: _*)
