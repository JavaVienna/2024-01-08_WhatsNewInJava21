package com.dominikdorn.whatsnewinjava.java21.recordpatterns;

public class R04FailedMatch {
  record Pair(Object x, Object y) {}

  public static void main(String[] args) {
    Pair p = new Pair(42d, 42d);

    System.out.println("checking by type");
    if (p instanceof Pair(String s, String t)) {
      System.out.println(s + ", " + t);
    } else {
      System.out.println("Not a pair of strings");
    }

    if (p instanceof Pair(Integer s, Integer t)) {
      System.out.println("xxx" + s + ", " + t);
    } else {
      System.out.println("Not a pair of ints");
    }

    if (p instanceof Pair(Double s, Double t)) {
      System.out.println("ddd" + s + ", " + t);
    } else {
      System.out.println("Not a pair of doubles");
    }

    if (p instanceof Pair(Number s, Number t)) {
      System.out.println("xxx" + s + ", " + t);
    } else {
      System.out.println("Not a pair of ints");
    }

    System.out.println("checking generally");
    if (p instanceof Pair(var s, var t)) {
      System.out.println("vars: (" + s + ", " + t +")");
    } else {
      System.out.println("this should have always matched");
    }

  }

}
