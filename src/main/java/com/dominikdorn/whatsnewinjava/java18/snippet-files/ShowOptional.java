package com.dominikdorn.whatsnewinjava.java18;

import java.util.Optional;

public class ShowOptional {
  void show(Optional<String> v) {
    // @start region="example"
    if (v.isPresent()) {
      System.out.println("v: " + v.get());
    }
    // @end
  }
}