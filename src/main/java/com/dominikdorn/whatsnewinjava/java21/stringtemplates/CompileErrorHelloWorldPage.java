package com.dominikdorn.whatsnewinjava.java21.stringtemplates;

public class CompileErrorHelloWorldPage {

  public static void main(String[] args) {

    var title = "Java-Vienna - Homepage";
    var message = "Hello Vienna!";
    // STR ist immer im Scope!
    System.out.println(
        // uncomment next line for compile error
        STR.
        """
        <html>
        <head>
          <title>\{title}
        </head>
          <body>
            <p>\{message}</p>
          </body>
        </html>
        """);
    // -->
    // CompileErrorHelloWorldPage.java:13:1: processor missing from string template expression
  }

}
