package com.dominikdorn.whatsnewinjava.java21.structuredconcurrencypreview;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class S02DOS {

  static class HttpClient {

    public String get(String url) throws InterruptedException {
      Thread.sleep(1500);
      return Thread.currentThread().threadId() + ":" + url;
    }

  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    var client = new HttpClient();

    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

      var requests = IntStream.range(0, 1_000_000)
          .mapToObj(i -> scope.fork(() -> client.get("https://www.google.com"))).collect(
          Collectors.toList());

      scope.join();
      System.out.println("all threads joined, results are now hear");

      var results = requests.stream().map(it -> it.get()).collect(Collectors.toList());

      scope.throwIfFailed();
      System.out.println("results.size() = " + results.size());
    }

  }

}
