package com.dominikdorn.whatsnewinjava.java21.structuredconcurrencypreview;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class S01Sample {


  public static void main(String[] args) throws InterruptedException, ExecutionException {

    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      Subtask<String> task1 = scope.fork(() -> {
        Thread.sleep(1000);
        System.out.println("A: Thread.name" + Thread.currentThread().getName());
        System.out.println("A: IsVirutal: " + Thread.currentThread().isVirtual());

        return "A";
      });
      Subtask<String> task2 = scope.fork(() -> { Thread.sleep(1000);
        System.out.println("B: Thread.name" + Thread.currentThread().getName());
        System.out.println("B: IsVirutal: " + Thread.currentThread().isVirtual());
        return "B";
      });
      Subtask<String> task3 = scope.fork(() -> { Thread.sleep(1000);
        System.out.println("C: Thread.name" + Thread.currentThread().getName());
        System.out.println("C: IsVirutal: " + Thread.currentThread().isVirtual());
        return "C";
      });
      System.out.println("all threads started");

      var r = scope.join();
      System.out.println("all threads joined");
      scope.throwIfFailed();
      System.out.println(task1.get()); System.out.println(task2.get()); System.out.println(task3.get());
    }

  }

}
