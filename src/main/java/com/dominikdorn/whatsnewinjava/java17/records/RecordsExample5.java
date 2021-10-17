package com.dominikdorn.whatsnewinjava.java17.records;

import java.util.Optional;
import java.util.stream.Stream;

public class RecordsExample5 {

  sealed interface Identity permits UserPassword, OAuth {
  }

  record UserPassword(int id, String username, String password) implements Identity {}
  record OAuth(String token) implements Identity {}

  private static Stream<Identity> getUserList() {
    return Stream.of(
        new UserPassword(1, "dominik", "java-vienna"),
        new UserPassword(2, "sigi", "jugat"),
        new OAuth("maxijava")
    );
  }

  private static Optional<Identity> authenticateUserPass(String user, String pass) {
    return getUserList().filter(id -> switch (id) {
      case UserPassword u && (u.username.equals(user) && u.password.equals(pass)) -> true;
//      case UserPassword(var id, var username, var password) && (sername.equals(user) && password.equals(pass)) -> true;
//      case OAuth(String token) -> false
      case OAuth o && o.token.equals(user+pass) -> true;
      default -> false;
    }).findFirst();
  }


  public static void main(String[] args) {

    println(authenticateUserPass("bla", "blu"));

    println(authenticateUserPass("dominik", "java-vienna"));

    println(authenticateUserPass("maxi", "java"));

  }

  private static void println(Object o) { System.out.println(o);}
}
