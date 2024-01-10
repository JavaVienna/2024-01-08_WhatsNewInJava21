package com.dominikdorn.whatsnewinjava.java18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileReaderExample {

  static String toString(FileReader r) throws IOException {
    return new BufferedReader(r).readLine();
  }

  public static void main(String[] args) throws Exception {

    System.out.println("new default:");
    // default
    {
      var r = new FileReader("src/main/resources/samples/java18/hello.txt");
      System.out.println("r.getEncoding() = " + r.getEncoding());
      System.out.println("toString(r) = " + toString(r));
    }

    // previous windows
    System.out.println("previous windows default (de-AT):");
    {
      var r = new FileReader("src/main/resources/samples/java18/hello.txt", Charset.forName("ISO-8859-9"));
      System.out.println("r.getEncoding() = " + r.getEncoding());
      System.out.println("toString(r) = " + toString(r));
    }

    //previous windows (e.g. Japan)
    {
      var r = new FileReader("src/main/resources/samples/java18/hello.txt", Charset.forName("ISO-2022-JP"));
      System.out.println("r.getEncoding() = " + r.getEncoding());
      System.out.println("toString(r) = " + toString(r));
    }

//    System.out.println("All Charsets");
//    Charset.availableCharsets().forEach((k, v) -> System.out.println(k + " -> " + v));



  }
}
