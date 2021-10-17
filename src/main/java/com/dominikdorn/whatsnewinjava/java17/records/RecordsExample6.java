package com.dominikdorn.whatsnewinjava.java17.records;

public class RecordsExample6 {

  record TestRecord(double c) {
    public TestRecord(double a, double b) {
      this(Math.sqrt(Math.pow(a, 2.0d) * Math.pow(b, 2.0d)));
    }
  }

  public static void main(String[] args) {
    println(new TestRecord(5.0));
    println(new TestRecord(7,8));
  }

  private static void println(Object o) { System.out.println(o);}
}
