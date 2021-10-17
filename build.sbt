ThisBuild / organization := "com.dominikdorn.jsug"

lazy val root = (project in file("."))
  .settings(
    name := "whatsnewinjava",
    javacOptions ++= Seq("-source", "17", "-target", "17", "--enable-preview"),
//    javaOptions ++= Seq("--enable-preview")
  )
