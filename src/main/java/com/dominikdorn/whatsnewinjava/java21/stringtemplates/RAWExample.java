package com.dominikdorn.whatsnewinjava.java21.stringtemplates;

import static java.lang.StringTemplate.RAW;

import java.lang.StringTemplate.Processor;

public class RAWExample {

  public static StringTemplate machwas () {
    var title = "Java-Vienna - Homepage";
    var message = "Hello Vienna!";

    StringTemplate stringTemplate = RAW."""
        <html>
        <head>
          <title>\{title}</title>
        </head>
          <body>
            <p>\{message}</p>
          </body>
        </html>
        """;
    return stringTemplate;
  }

  public static void main(String[] args) {

    var stringTemplate = machwas();


    System.out.println("Fragments:");
    stringTemplate.fragments().stream().forEach(System.out::println);

    System.out.println("Values:");
    stringTemplate.values().stream().forEach(System.out::println);

    System.out.println("Result:");
    System.out.println(stringTemplate.interpolate());
  }
}
