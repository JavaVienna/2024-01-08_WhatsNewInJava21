package com.dominikdorn.whatsnewinjava.java21.recordsswitch;

public class R04PatternsInSwitchLabels {
  static String patternSwitchTest(Object obj) {
    String formatted = switch (obj) {
      case Integer i -> String.format("int %d", i);
      case Long l    -> String.format("long %d", l);
      case Double d  -> String.format("double %f", d);
      case String s  -> String.format("String %s", s);
      case null -> "nullxxx";
      default       -> String.valueOf(obj);
    };
    return formatted;
  }

  public static void main(String[] args) {

//    System.out.println(patternSwitchTest(Double.valueOf(5.38d)));
    System.out.println(patternSwitchTest(null));

  }

}
