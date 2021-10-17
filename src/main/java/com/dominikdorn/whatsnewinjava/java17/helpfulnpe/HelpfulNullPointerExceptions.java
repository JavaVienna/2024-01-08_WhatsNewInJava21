package com.dominikdorn.whatsnewinjava.java17.helpfulnpe;

class Address {
  String street;
}

class Example {
  String data;
  Address address;
}


public class HelpfulNullPointerExceptions {
 public static void main(String[] args) {
   var e = new Example();

   try {
    e.data.length();
   } catch (NullPointerException ex) {
     // Cannot invoke "String.length()" because "e.data" is null
     System.out.println(ex.getMessage());
   }

   var ex = new Example();
   ex.address = new Address();
   try {
     ex.address.street.length();
   } catch (NullPointerException t) {
     // Cannot invoke "String.length()" because "ex.address.street" is null
     System.out.println(t.getMessage());
   }
 }
}
