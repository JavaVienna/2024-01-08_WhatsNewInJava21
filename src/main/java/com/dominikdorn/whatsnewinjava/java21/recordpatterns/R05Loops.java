package com.dominikdorn.whatsnewinjava.java21.recordpatterns;

import java.util.List;
import java.util.stream.Collectors;

public class R05Loops {
  record Point(int x, int y) {}

  public static void main(String[] args) {

    var points = List.of(
        new Point(1,1), new Point(1,2), new Point(1,3),
        new Point(2,1), new Point(2,2), new Point(2,3),
        new Point(3,1), new Point(3,2), new Point(3,3)

        );

    //alt
    for(Point p : points) {
      System.out.println("x = " + p.x + "/ y = " + p.y);
    }
//
//    // not yet working but "in the works"
//    for(Point(var x, var y) : points) {
//      System.out.println("x = " + x + "/ y = " + y);
//    }

    var sum1 = points.stream().map(p -> p.x+p.y).reduce((a, b) -> a + b);

    // not working, controversal, "in discussion"
//    var sum2 = points.stream().map(Point(var x, var y) -> x+y).reduce((a, b) -> a + b);


  }
}
