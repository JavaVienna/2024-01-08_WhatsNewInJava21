package com.dominikdorn.whatsnewinjava.java21.recordpatterns;

public class R02NestedInstanceOf {
  record Point(int x, int y) {}
  enum Color { RED, GREEN, BLUE }
  record ColoredPoint(Point p, Color c) {}
  record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}


  // shallow
  static void printUpperLeftColoredPoint(Rectangle r) {
    if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
      System.out.println(ul.c());
    }
  }

  // deeply
  static void printColorOfUpperLeftPoint(Rectangle r) {
    if (r instanceof Rectangle(ColoredPoint(Point p, Color c),
                               ColoredPoint lr)) {
      System.out.println(c);
    }
  }

   static void printColorOfUpperLeftPoint2(Rectangle r) {
    if (r instanceof Rectangle(ColoredPoint(Point(var x, var y), Color c),
                               ColoredPoint lr)) {
      System.out.println(c);
    }
  }

  public static void main(String[] args) {

    var linksOben = new Point(1, 10);
    var rechtsUnten = new Point(10, 1);

    var linksObenC = new ColoredPoint(linksOben, Color.RED);
    var rechtsUntenC = new ColoredPoint(rechtsUnten, Color.BLUE);
    var rectangle = new Rectangle(linksObenC, rechtsUntenC);

    printUpperLeftColoredPoint(rectangle);
    printColorOfUpperLeftPoint(rectangle);
  }

}
