package com.dominikdorn.whatsnewinjava.java9.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientSample1 {

  public static void main(String[] args)
      throws URISyntaxException, IOException, InterruptedException {

    var req = HttpRequest
        .newBuilder()
        .uri(new URI("https://www.google.com/?q=java+vienna"))
        .GET()
        .build()
        ;

      var client = HttpClient.newHttpClient();

      var resp = client.send(req, HttpResponse.BodyHandlers.ofString());
      println(resp);
      println(resp.body());
  }

  private static void println(Object o) {
    System.out.println(o);
  }

}
