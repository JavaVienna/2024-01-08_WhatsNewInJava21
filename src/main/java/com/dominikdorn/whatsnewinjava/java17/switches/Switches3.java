package com.dominikdorn.whatsnewinjava.java17.switches;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Switches3 {

  interface Type {}

  record Email(String user, String host) implements Type {}
  record Url(String schema, String host, String remaining) implements Type {}


  public static void main(String[] args) {

    println(parseString("dominik@dominikdorn.com"));
    println(parseString("http://java.wien"));
    println(parseString("webex://adfadsfadf"));

  }

  static Pattern emailPattern = Pattern.compile("^([a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+)@([a-zA-Z0-9.-]+)$");
  static Pattern httpUrlPattern = Pattern.compile("^(https?):\\/\\/((www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6})\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)$");

  static Optional<Type> parseString(String s) {

    switch (s) {
      case String e when (emailPattern.matcher(e).matches()) -> {
        println("email matched");
//        var m = emailPattern.matcher(e);
//        m.matches();
//        return Optional.of(new Email(m.group(1), m.group(2)));
      }
      case String u when (httpUrlPattern.matcher(u).matches()) -> {
        println("url matched");
//        var m = httpUrlPattern.matcher(u);
//        m.matches();
//        return Optional.of(new Url(m.group(1), m.group(2), m.group(3)));
      }
      default -> println("didn't match");
    }
    return null;
  }

  static void println(Object o){
    System.out.println(String.valueOf(o));
  }

}
