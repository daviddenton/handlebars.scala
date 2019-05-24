import sbtcrossproject.CrossPlugin.autoImport.{CrossType, crossProject}

// Due to the cross project being in(file(".")), we need to prevent
// the automatic root project from compiling.
Compile / unmanagedSourceDirectories := Nil
Test / unmanagedSourceDirectories := Nil
publish := {}
publishArtifact := false

val orgName = "io.github.daviddenton"

val projectName = "handlebars-scala-fork"

ThisBuild / licenses := Seq("BSD" -> url("http://www.opensource.org/licenses/bsd-license.php"))
ThisBuild / credentials += Credentials(Path.userHome / ".sonatype" / ".credentials")

lazy val `handlebars-scala-fork` = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Full)
  .in(file("."))
  .settings(
    organization := orgName,
    name := projectName,

    pomExtra :=
      <url>https://github.com/mwunsch/handlebars.scala</url>
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
        </developer>
      </developers>,

    scalaVersion := "2.12.8",
    crossScalaVersions := Seq("2.12.8", "2.11.12"),

    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-language:implicitConversions"),

    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %%% "scala-parser-combinators" % "1.0.5",
      "org.scalatest" %%% "scalatest" % "3.0.7" % Test))
  .jsSettings(
    libraryDependencies += "biz.enef" %%% "slogging" % "0.6.1")
  .jvmSettings(
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % "1.6.4",
      "org.slf4j" % "slf4j-simple" % "1.6.4" % Test))



