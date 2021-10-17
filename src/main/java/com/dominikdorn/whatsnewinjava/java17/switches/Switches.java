package com.dominikdorn.whatsnewinjava.java17.switches;

interface Animal {
  String species();
}

class Cat implements Animal {

  @Override
  public String species() {
    return "cat";
  }
  public void miau() {
    System.out.println("miau");
  }
}

class Dog implements Animal {

  @Override
  public String species() {
    return "dog";
  }
  public void woof() {
    System.out.println("woof!");
  }
}

class Elephant implements Animal {

  @Override
  public String species() {
    return "elephant";
  }
  public void makeSound() {
    System.out.println("töröö!");
  }
}


// JEP 361: Switch Expressions
// since Java 14
// JEP 354: Switch Expressions (Second Preview)
// Java 13
public class Switches {
  // This is a preview feature, enable with --enable-preview!
  public static void main(String[] args) {
    var tom = new Cat();
    var scooby = new Dog();
    var benjamin = new Elephant();


    makeThaSoundSwitcher(tom);
    makeThaSoundSwitcher(scooby);
    makeThaSoundSwitcher(benjamin);
    makeThaSoundSwitcher("blabal");
    makeThaSoundSwitcher(null);
  }

  public static void makeThaSoundSwitcher(Object obj) {
    makeThaSoundBetter(obj);
  }

  public static void makeThaSoundOld(Object object) {
    if ( object instanceof Cat) {
      ((Cat) object).miau();
    } else if ( object instanceof Dog) {
      ((Dog) object).woof();
    } else if ( object instanceof Elephant) {
      ((Elephant) object).makeSound();
    } else if (object == null) {
      System.out.println("oh noooo, got a null!");
    } else {
      System.out.println("unknown object old: " + object);
    }
  }

  //<editor-fold desc="better">
  public static void makeThaSoundBetter(Object object) {
    if ( object instanceof Cat c) {
      c.miau();
    } else if ( object instanceof Dog d) {
      d.woof();
    } else if ( object instanceof Elephant e) {
      e.makeSound();
    } else if (object == null) {
      System.out.println("oh noooo, got a null!");
    } else {
      System.out.println("unknown object old: " + object);
    }
  }
  //</editor-fold>

  //<editor-fold desc="new">
  public static void makeThaSoundNew(Object object) {
    switch (object) {
      case Cat c -> c.miau();
      case Dog d -> d.woof();
      case Elephant e -> e.makeSound();
      case null -> System.out.println("oh noooo, got a null!");
      default -> System.out.println("unknown object new: " + object);
    }
  }
  //</editor-fold>



}
