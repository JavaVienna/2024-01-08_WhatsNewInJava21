package com.dominikdorn.whatsnewinjava.java21.stringtemplates;

import static java.util.FormatProcessor.FMT;

public class FMTTemperatur {

  public static void main(String[] args) {

    float gefuehltWie = 8;
    float temp = 16.0f;
    String unit = "°C";

    String result = FMT. """
    Das Wetter morgen:
    Temperatur: %2.2f\{ temp } \{ unit }
    Gefühlt wie: %2.2f\{ gefuehltWie } \{ unit }
        """ ;

    System.out.println(result );

  }
}
