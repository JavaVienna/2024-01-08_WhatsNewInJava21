package com.dominikdorn.whatsnewinjava.java17.records;

public class RecordsExample2 {

  record User(String name, int age) {
    User {
      if(age < 0 || age > 100) {
        throw new IllegalArgumentException("invalid age " + age  + " for user " + name + " given!");
      }
    }
  }

  public static void main(String[] args) {

    println(new User("Dominik", 35));
    println(new User("uropa", 105));


  }
  static void println(Object o ) { System.out.println(o);}
}
