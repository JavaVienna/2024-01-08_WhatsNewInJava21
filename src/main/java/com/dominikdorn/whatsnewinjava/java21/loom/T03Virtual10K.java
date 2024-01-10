package com.dominikdorn.whatsnewinjava.java21.loom;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class T03Virtual10K {

  public static void main(String[] args) {
    var start = System.currentTimeMillis();
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      IntStream.range(0, 10_000).forEach(i -> {
        executor.submit(() -> {
          Thread.sleep(Duration.ofSeconds(1));
          System.out.println(i);
          return i;
        });
      });
    }  // executor.close() is called implicitly, and waits

    var end = System.currentTimeMillis();
    System.out.println(STR."we waited \{end - start}ms");
  }
}
