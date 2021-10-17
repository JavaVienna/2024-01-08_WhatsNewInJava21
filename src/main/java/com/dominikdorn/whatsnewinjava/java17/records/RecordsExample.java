package com.dominikdorn.whatsnewinjava.java17.records;

record User (String name, int age, Address address) {
  boolean isOlderThan(User u) {
    return this.age > u.age;
  }
}
record Address (String street, String city) {}

public class RecordsExample {

  public static void main(String[] args) {
    var dominik = new User("Dominik", 35, new Address("Oldguy Street", "Vienna"));
    System.out.println(dominik);

    var maxi = new User("Maxi", 21, new Address("Youngguy Street", "Vienna"));

    System.out.println(dominik.isOlderThan(maxi));

  }
}






