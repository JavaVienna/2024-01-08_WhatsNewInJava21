package com.dominikdorn.whatsnewinjava.java21.recordpatterns;


public class R03NestedVar {
  static record Point(int x, int y) {}
  static enum Color { RED, GREEN, BLUE }
  static record ColoredPoint(Point p, Color c) {}
  static record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}

  static void printXCoordOfUpperLeftPointWithPatterns(Rectangle r) {
    if (r instanceof Rectangle(ColoredPoint(Point(var x, var y), var c),
                               var lr)) {
      System.out.println("Upper-left corner: " + x);
    }
  }
  public static void main(String[] args) {
    var linksOben = new Point(1, 10);
    var rechtsUnten = new Point(10, 1);

    var linksObenC = new ColoredPoint(linksOben, Color.RED);
    var rechtsUntenC = new ColoredPoint(rechtsUnten, Color.BLUE);
    var rectangle = new Rectangle(linksObenC, rechtsUntenC);

    printXCoordOfUpperLeftPointWithPatterns(rectangle);

  }
}
