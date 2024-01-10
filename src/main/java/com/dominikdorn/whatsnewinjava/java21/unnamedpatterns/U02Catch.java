package com.dominikdorn.whatsnewinjava.java21.unnamedpatterns;

public class U02Catch {
  public static void main(String[] args) {
    try {
      throw new Exception("Hello World!");
    } catch (Exception _) {
        System.out.println("something bad happened");
    }
  }
}
