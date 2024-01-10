package com.dominikdorn.whatsnewinjava.java21.structuredconcurrencypreview;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class S02RealHttpClient {


  public static void main(String[] args) throws InterruptedException, ExecutionException {

    var client = HttpClient.newHttpClient();

    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

      var requests = IntStream.range(1, 1_000)
          .mapToObj(i -> scope.fork(() -> {

            try {
              return client.send(
                  HttpRequest.newBuilder(URI.create("http://localhost:8000")).GET().build(),
                  BodyHandlers.ofString()
              ).body();
            } catch (Exception e) {
              return "request failed";
            }
          })).collect(
              Collectors.toList());

      scope.join();
      System.out.println("all threads joined, results are now hear");

      var results = requests.stream().map(it -> it.get()).collect(Collectors.toList());

      System.out.println(STR."Total requests sent: \{ results.size()}");
      var failed = results.stream().filter(it -> it.contains("failed")).count();
      System.out.println(STR."we got #\{failed} failed requests ");
    }

  }

}
