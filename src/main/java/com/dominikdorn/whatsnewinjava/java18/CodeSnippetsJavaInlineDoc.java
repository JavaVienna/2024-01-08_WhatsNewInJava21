package com.dominikdorn.whatsnewinjava.java18;

public class CodeSnippetsJavaInlineDoc {

  /**
   * The following code shows how to use {@code Optional.isPresent}:
   * {@snippet :
   * if (v.isPresent()) {
   *     System.out.println("v: " + v.get());
   * }
   * }
   */
  public boolean isPresent() {
    java.util.Optional.of(null).isPresent(); // sadly not applied in the javadocs
    return true;
  }



}
