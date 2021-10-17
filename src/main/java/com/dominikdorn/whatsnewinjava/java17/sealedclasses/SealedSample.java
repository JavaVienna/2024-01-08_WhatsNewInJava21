package com.dominikdorn.whatsnewinjava.java17.sealedclasses;

// sealed classes
// feingranulare Kontrolle über Vererbung

import java.util.List;
import java.util.stream.Collectors;

sealed interface PaymentProcessor permits Paypal, Sofort, Wise {

}

// sealed class kann noch vererbt werden im gleichen File
// -> Paypal2 file anschauen
sealed class Paypal implements PaymentProcessor  {

}

// non-sealed kann nicht mehr vererbt werden, vgl. final
non-sealed class PaypalBusiness extends Paypal {

}

final class PaypalBusiness2 extends Paypal {

}

record Wise (String bla) implements PaymentProcessor {}

// final class kann nicht mehr erweitert werden
final class Sofort implements PaymentProcessor {

}


//<editor-fold desc="unsupported">
//final class Wirecard implements PaymentProcessor {
//  // this is not supported! (gut so :D)
//}
//</editor-fold>

public class SealedSample {

  public static void main(String[] args) {
    PaymentProcessor pp = null;
    switch (pp) {
      case Sofort s -> println("sofort!");
      case PaypalBusiness pb -> println("paypal business");
      case PaypalBusiness2 pb2 -> println("paypal business 2");
      case Paypal p -> println("generic paypal");
      case null -> println("got null");
      default -> println("not expecting");
    }

    reflection();
  }

  /*
  Summary:

  - sealed: wird auf der obersten Ebene spezifiziert und die erlaubten (permit) Subclasses definiert
  Implementierungen einer sealed Klasse müssen entweder
  - non-sealed: gibt explizit an, dass von dieser Klasse Unterklassen definiert werden koennen.
  - final: keine Unterklassen erlaubt
   */

  private static void adhoc() {
//    PaymentProcessor pp = new PaymentProcessor() {
//      // geht nicht weil sealed
//    };

//    PaymentProcessor pp = new Paypal() {
//      // geht nicht weil sealed
//    }

    PaymentProcessor pp = new PaypalBusiness() {
      // geht weil non-sealed
    };

//    PaymentProcessor pp2 = new PaypalBusiness2() {
//      // geht nicht weil final
//    };

  }


  private static void reflection() {
    println("Payment Processor: is sealed?" + PaymentProcessor.class.isSealed());
    println("Payment Processor: permitted subclasses? \n" + toString(PaymentProcessor.class.getPermittedSubclasses()));


    PaymentProcessor paypalSealed = new Paypal();
    println("is sealed?" + paypalSealed.getClass().isSealed());
    println("permit subclasses: \n" + toString(paypalSealed.getClass().getPermittedSubclasses()));


    PaymentProcessor adhocSubclass = new PaypalBusiness(){
      void bla(){ }
    };
    println("ADHOC: is sealed?" + adhocSubclass.getClass().isSealed());
    println("ADHOC: permitted subclasses: \n" + toString(adhocSubclass.getClass().getPermittedSubclasses()) );


    PaymentProcessor finalClass = new PaypalBusiness2();
    println("final: is sealed?" + finalClass.getClass().isSealed());
    println("final: permitted subclasses: \n" + toString(finalClass.getClass().getPermittedSubclasses()) );

  }


  private static void println(String s) { System.out.println(s);}
  private static String toString(Class<?>[] c){
    if(c == null) { return "[]"; }
    return List.of(c).stream().map(x -> x.getName()).collect(Collectors.joining(",\n", "[\n", "\n]"));
  }
}
