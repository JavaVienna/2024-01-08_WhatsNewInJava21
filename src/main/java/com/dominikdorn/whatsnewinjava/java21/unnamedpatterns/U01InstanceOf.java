package com.dominikdorn.whatsnewinjava.java21.unnamedpatterns;

public class U01InstanceOf {
  record Point(Object x, int y) {}
  record PointN(int x, int y, int a, int b, int c) {}


  public static void main(String[] args) {

    var point = new Point("blabla", 2);

    if (point instanceof Point(String _, int y)) {
      System.out.println("y = " + y);
      System.out.println(point.x);
    } else {
      System.out.println("not matched");
    }
  }
}
