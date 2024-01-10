package com.dominikdorn.whatsnewinjava.java21.loom;

public class T01ClassicThreads {

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello from Thread");
      }
    });

    t.start();
    t.join();
  }
}
