package com.dominikdorn.whatsnewinjava.java17.records;

public class RecordsExample3 {

  record User(String name, int age) {
    User withName(String name) {
      return new User(name, age);
    }
    User withAge(int age) {
      return new User(name, age);
    }

    User getOlder(){
      return new User(name, age+1);
    }

  }

  public static void main(String[] args) {

    var dominik = new User("dominik", 35);
    var oldDominik = dominik.withAge(85);

    println(dominik);
    println(oldDominik);
    println(dominik.getOlder());

    var afterGraduation = dominik.withName("Dr Dominik").withAge(38);
    println(afterGraduation);
  }

  static void println(Object o ) { System.out.println(o);}

}
