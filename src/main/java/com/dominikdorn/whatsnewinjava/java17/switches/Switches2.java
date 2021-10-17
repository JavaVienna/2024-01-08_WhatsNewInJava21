package com.dominikdorn.whatsnewinjava.java17.switches;

public class Switches2 {

  enum Weapon {
    HAND, GUN, MACHINE_GUN, GRENADE;
  }

  static void println(String s) {
    System.out.println(s);
  }

  public static void main(String[] args) {
    println("Damages of");
    println("Hand Damage should be 1 == " + (damageSwitcher(Weapon.HAND) == 1));
    println("Gun Damage should be 100 == " + (damageSwitcher(Weapon.GUN) == 100));
    println("Machine Damage should be 600 == " + (damageSwitcher(Weapon.MACHINE_GUN) == 600));
    println("Grenade Damage should be 1000 == " + (damageSwitcher(Weapon.GRENADE) == 1000));
    println("null Damage should be -1 == " + (damageSwitcher(null) == -1));
  }

  static int damageSwitcher(Weapon weapon){
    return getDamageOld(weapon);
//    return getDamageNewer(weapon);
//    return getDamageAdvanced(weapon);
//    return getDamageAdvancedColon(weapon);
  }

  static int getDamageOld(Weapon weapon) {
    if( weapon == Weapon.HAND ) {
      return 1;
    } else if ( weapon == Weapon.GUN) {
      return 100;
    } else if ( weapon == Weapon.MACHINE_GUN) {
      return 600;
    } else if ( weapon == Weapon.GRENADE) {
      return 1000;
    } else {
      return -1;
    }
  }

  //<editor-fold desc="newer">
  static int getDamageNewer(Weapon weapon) {
    // null check required
    if (weapon == null) {
      return -1;
    } else
      switch (weapon) {
        case HAND: return 1;
        case GUN: return 100;
        case MACHINE_GUN: return 600;
        case GRENADE: return 1000;
        default: return -1;
      }
  }
  //</editor-fold>

  //<editor-fold desc="advanced">
  static int getDamageAdvanced(Weapon weapon) {
    var damage = switch (weapon) {
      case HAND -> 1;
      case GUN -> 100;
      case MACHINE_GUN -> 600;
      case GRENADE -> 1000;
      case null, default -> -1; // null handling here!
    };
    return damage;
  }
  //</editor-fold>

  // <editor-fold desc="colon-syntax">
  static int getDamageAdvancedColon(Weapon weapon) {
    var damage = switch (weapon) {
      case HAND: yield 1;
      case GUN: yield 100;
      case MACHINE_GUN: yield 600;
      case GRENADE: yield 1000;
      case null, default: yield -1;
    };
    return damage;
  }
  //</editor-fold>


}
