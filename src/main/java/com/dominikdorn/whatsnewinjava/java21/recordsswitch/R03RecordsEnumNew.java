package com.dominikdorn.whatsnewinjava.java21.recordsswitch;

public class R03RecordsEnumNew {
  sealed interface CardClassification permits Suit, Tarot {}
  public enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
  final class Tarot implements CardClassification {}

  static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
    switch (c) {
      case Suit.CLUBS -> {
        System.out.println("It's clubs");
      }
      case Suit.DIAMONDS -> {
        System.out.println("It's diamonds");
      }
      case Suit.HEARTS -> {
        System.out.println("It's hearts");
      }
      case Suit.SPADES -> {
        System.out.println("It's spades");
      }
      case Tarot t -> {
        System.out.println("It's a tarot");
      }
    }
  }

  public static void main(String[] args) {
    exhaustiveSwitchWithBetterEnumSupport(Suit.HEARTS);
  }
}
