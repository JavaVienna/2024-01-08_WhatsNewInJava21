package com.dominikdorn.whatsnewinjava.java17.textblocks;

import java.util.UUID;

public class Textblocks {

  public static void main(String[] args) {
    var old = "<html>\n" +
        "<head>\n" +
        "<title>Java Vienna!</title>\n" +
        "</head>\n</html>";
    println(old);

    //<editor-fold desc="html">
    var html = """
        <html>
          <head>
            <title>Hello JSUG!</title>
          </head>
        </html>
        """;
//    println(html);
    //</editor-fold>

    //<editor-fold desc="query">
    var query = """
        SELECT
          u.name,
          u.age,
          a.street
        FROM
          "user" u
            join
          address a ON (a.user_id = u.id)
        WHERE
          a.city = 'vienna';
        """;
//    println(query);
    //</editor-fold>


    //<editor-fold desc="Parameters 1">
    var parameters1 = """
        Hello %s!
        
        Welcome to our service!
        Please click %s to activate your account!
        
        Sincerly, 
        SAAS-Startup
        
        """.formatted("user@host.com", "https://www.mysaas.com/activate?" + UUID.randomUUID().toString());
//    println(parameters1);
    //</editor-fold>


    //<editor-fold desc="Parameters 2">
    var parameters2 = """
        Hello $username!
        
        Welcome to our service!
        Please click $link to activate your account!
        
        Sincerly, 
        SAAS-Startup
        
        """.replace("$username", "user@host.com")
        .replace("$link", "https://www.mysaas.com/activate?" + UUID.randomUUID().toString());
//    println(parameters2);
    //</editor-fold>

    //<editor-fold desc="whitespace">
    var whitespace = """
        no space on ma right    
        some space on ma right    \s
        yolo!
        """.replace(" ", "*");
//    println(whitespace);
    //</editor-fold>

  }

  private static void println(Object o) { System.out.println(o);}
}
