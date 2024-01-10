package com.dominikdorn.whatsnewinjava.java18;

public class CodeSnippetsJavaExternalDoc {

  /**
   * The following code shows how to use {@code Optional.isPresent}:
   * {@snippet file="ShowOptional.java" region="example"}
   */
  public boolean isPresent() {
    java.util.Optional.of(null).isPresent(); // sadly not applied in the javadocs
    return true;
  }



}
