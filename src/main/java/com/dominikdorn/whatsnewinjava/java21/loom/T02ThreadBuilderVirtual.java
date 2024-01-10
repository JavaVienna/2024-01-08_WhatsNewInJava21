package com.dominikdorn.whatsnewinjava.java21.loom;

public class T02ThreadBuilderVirtual {

  public static void main(String[] args) throws InterruptedException {

    Thread.Builder builder = Thread.ofVirtual();
    var t = builder.name("jsug-virtual").start(new Runnable() {
      @Override
      public void run() {
        System.out.println( "bin ich virtuell?: " + Thread.currentThread().isVirtual());
        System.out.println("my name is: " + Thread.currentThread().getName());
        System.out.println("ThreadGroup: " + Thread.currentThread().getThreadGroup().getName());

      }
    });
    t.join();
  }

}
