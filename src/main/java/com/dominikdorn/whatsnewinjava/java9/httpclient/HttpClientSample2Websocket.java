package com.dominikdorn.whatsnewinjava.java9.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class HttpClientSample2Websocket {

  public static void main(String[] args)
      throws URISyntaxException, IOException, InterruptedException, ExecutionException {

    var uri = new URI("wss://demo.piesocket.com/v3/channel_1?api_key=oCdCMcMPQpbvNjUIzqtvF1d2X2okWpDQj4AwARJuAgtjhzKxVEjQU6IdCjwm&notify_self");

    var client = HttpClient.newHttpClient();

    var listener = new Listener() {
      @Override
      public void onOpen(WebSocket webSocket) {
        Listener.super.onOpen(webSocket);
        println("websocket opened");
//        webSocket.sendPing(ByteBuffer.wrap("Hello".getBytes())).join();
//        webSocket.sendText("yolo", false).join();
      }

      @Override
      public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        webSocket.request(1);
        println("on text");
        println("data = " + data);
        return webSocket.sendText("X" + data, true);
      }

      @Override
      public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
        println("on binary");
        return Listener.super.onBinary(webSocket, data, last);
      }

      @Override
      public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        println("received ping: " + message.asCharBuffer());
        return CompletableFuture.completedFuture("");
      }

      @Override
      public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        println("received pong: " + message.toString());
        return CompletableFuture.completedFuture("");
      }

      @Override
      public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        println("closing connection");
        return CompletableFuture.completedFuture("");
      }

      @Override
      public void onError(WebSocket webSocket, Throwable error) {
        println("there was a error!");
        error.printStackTrace();

      }
    };

    var websocket = client.newWebSocketBuilder().buildAsync(uri, listener).get();

    // https://www.piesocket.com/websocket-tester#
    websocket.sendText("bla", true);
    Thread.sleep(10000);

  }

  private static void println(Object o) {
    System.out.println(o);
  }

}
