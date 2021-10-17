package com.dominikdorn.whatsnewinjava.java9.processmanager;

public class Loop {

  public static void main(String[] args) throws InterruptedException {
    while (true) {
      System.out.println(System.currentTimeMillis());
      Thread.sleep(1000);
    }
  }
}
