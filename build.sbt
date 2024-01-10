ThisBuild / organization := "com.dominikdorn.jsug"

lazy val root = (project in file("."))
  .settings(
    name := "whatsnewinjava",
    javacOptions ++= Seq("-source", "21", "-target", "21", "--enable-preview"),
    libraryDependencies ++= Seq(
      "org.mariadb.jdbc" % "mariadb-java-client" % "3.3.0",
      "com.mysql" % "mysql-connector-j" % "8.2.0",
      "com.zaxxer" % "HikariCP" % "5.1.0"

    )
//    javaOptions ++= Seq("--enable-preview")
  )
  .enablePlugins(JShellPlugin)


