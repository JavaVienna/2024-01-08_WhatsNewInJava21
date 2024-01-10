package com.dominikdorn.whatsnewinjava.java21.stringtemplates;

public class STRHelloWorldPage {

  public static void main(String[] args) {

    var title = "Java-Vienna - Homepage";
    var message = "Hello Vienna!";
    // STR ist immer im Scope!
    System.out.println(STR."das ist ein test \{title}");

    System.out.println(STR."""
        <html>
        <head>
          <title>\{title}
        </head>
          <body>
            <p>\{message}</p>
          </body>
        </html>
        """);
  }

}
