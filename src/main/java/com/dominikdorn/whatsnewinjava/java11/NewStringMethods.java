package com.dominikdorn.whatsnewinjava.java11;


public class NewStringMethods {

  private static void lines() {
    var str  = """
        line1 aaaa
        line2 bbbb
        line3 cccc
        line4 dddd
        """;

    System.out.println(str);
    str.lines().map(s -> s.substring(0, 5)).forEach(System.out::println);

  }

  private static void strip() {
    var str = "   adfa sdf asdf asdf   ";
    System.out.println(str.strip().replace(" ", "*"));
  }

  private static void repeat() {
    for(int i = 0; i <= 5; i++) {
      System.out.println("*".repeat(i));
    }
  }

  public static void main(String[] args) {
    lines();
    strip();
    repeat();
  }
}
