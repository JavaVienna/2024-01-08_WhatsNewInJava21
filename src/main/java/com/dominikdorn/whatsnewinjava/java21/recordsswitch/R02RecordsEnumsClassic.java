package com.dominikdorn.whatsnewinjava.java21.recordsswitch;

public class R02RecordsEnumsClassic {
  sealed interface CardClassification permits Suit, Tarot {}
  public enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
  final class Tarot implements CardClassification {}

  static void exhaustiveSwitchWithoutEnumSupport(CardClassification c) {
    switch (c) {
      case Suit s when s == Suit.CLUBS -> {
        System.out.println("It's clubs");
      }
      case Suit s when s == Suit.DIAMONDS -> {
        System.out.println("It's diamonds");
      }
      case Suit s when s == Suit.HEARTS -> {
        System.out.println("It's hearts");
      }
      case Suit s -> {
        System.out.println("It's spades");
      }
      case Tarot t -> {
        System.out.println("It's a tarot");
      }
    }
  }

  public static void main(String[] args) {

    exhaustiveSwitchWithoutEnumSupport(Suit.HEARTS);

  }

}
