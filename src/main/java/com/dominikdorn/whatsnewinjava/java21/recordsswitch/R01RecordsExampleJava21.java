package com.dominikdorn.whatsnewinjava.java21.recordsswitch;

import java.util.Optional;
import java.util.stream.Stream;

public class R01RecordsExampleJava21 {

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

  // Java17 Way
  /*private static Optional<Identity> authenticateUserPass(String user, String pass) {
    return getUserList().filter(id -> switch (id) {
      case UserPassword u && (u.username.equals(user) && u.password.equals(pass)) -> true;
//      case UserPassword(var id, var username, var password) && (sername.equals(user) && password.equals(pass)) -> true;
//      case OAuth(String token) -> false
      case OAuth o && o.token.equals(user+pass) -> true;
      default -> false;
    }).findFirst();
  }*/

  // Java19 Way
  private static Optional<Identity> authenticateUserPass(final String user, final String pass) {
    return getUserList().filter(id -> switch (id) {
      case UserPassword u when (u.username.equals(user) && u.password.equals(pass)) -> true; // this line could ideally be simplified to
//      case UserPassword(_, user, pass )  -> true; // TODO hopefully this gets implemented
//      case UserPassword(int userId, String username, String password) when (username.equals(user) && password.equals(pass)) -> true;
      case OAuth o when o.token.equals(user+pass) -> true;
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
