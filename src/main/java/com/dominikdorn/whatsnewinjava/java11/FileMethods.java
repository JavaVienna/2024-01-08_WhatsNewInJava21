package com.dominikdorn.whatsnewinjava.java11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileMethods {

  public static void main(String[] args) throws IOException {
    var classNameCanonical = FileMethods.class.getCanonicalName();
    var filename = classNameCanonical.replace(".", File.separator) + ".java";
    System.out.println(FileMethods.class.getCanonicalName());
    System.out.println(filename);
    var f = new File(new File("src/main/java"), filename);
    var path = f.toPath();
    System.out.println(path);
    System.out.println(Files.readString(path));
  }
}
