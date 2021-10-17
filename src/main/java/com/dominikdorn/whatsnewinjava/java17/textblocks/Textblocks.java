package com.dominikdorn.whatsnewinjava.java17.textblocks;

public class Textblocks {

  public static void main(String[] args) {
    var old = "<html>\n" +
        "<head>\n" +
        "<title>Java Vienna!</title>\n" +
        "</head>\n</html>";
    System.out.println(old);

    //<editor-fold desc="html">
    var html = """
        <html>
          <head>
            <title>Hello JSUG!</title>
          </head>
        </html>
        """;

//    System.out.println(html);
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
//    System.out.println(query);
    //</editor-fold>
  }
}
