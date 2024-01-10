package com.dominikdorn.whatsnewinjava.java21.recordpatterns;

public class R01InstanceOf {
  record Point(int x, int y) {}

  static void printSumJava16(Object obj) {
    if (obj instanceof Point p) {
      int x = p.x();
      int y = p.y();
      System.out.println(x+y);
    }
  }

  static void printSumJava21(Object obj) {
    if (obj instanceof Point(int x, int y)) {
      System.out.println(x+y);
    }
  }

  public static void main(String[] args) {
    var point = new Point(1, 2);

    printSumJava16(point);
    printSumJava21(point);
  }

}
