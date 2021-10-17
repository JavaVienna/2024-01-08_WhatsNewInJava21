
# 01 | java17/Textblocks
  - html, query, parameters 1, parameters 2, whitespace 

# 02 | java17/Helpful NPEs
 - direct variable, nested variable
 
# 03 | java17/switches

  switches on generic types
  - classsic
    - better instanceof
    - new arrow
  - java17/switches2 on enums
     - legacy if/else
     - new switch
     - colon/comma way

# 04 | java17/sealed types

- sealed interface
- sealed abstract class
- final/non-sealed

# 05 | java17/records

 - java17/records/1
     - basic records
     - instance methods
 - java17/records/2
     - constructors + assertions
 - java17/records/3
     - immutability
     - copy helpers
 - java17/records/4
     - records in methods/helper dtos
 - java17/records/5
     - records in switch statements in streams/filters (pattern matching)
 - java17/switches/3
    - pattern matching with regexp
 - java17/records/6
    - custom constructors

# 06 | java9 / httpclient / 1

 - httpclient / 1
   - basic get request
 - httpclient / 2
   - websocket client

# 07 | java9 / jshell
 - read–eval–print loop – REPL
 - show records
    ```java
    record User(int id, String name) {}
    System.out.println(new User(1, "dominik"));
   ```
   
     - show multi line strings
   ```
      var multilinestr = """
      das ist
      ein test
      eines
      sehr langen
      textes
      """

      System.out.println(multilinestr);
   ```
   
     - `/help intro`

     - ```
       jshell --enable-preview --class-path /Users/domdorn/jsug/whatsnewinjava/target/scala-2.12/classes:/Users/domdorn/.sbt/boot/scala-2.12.14/lib/scala-library.jar
       
       com.dominikdorn.whatsnewinjava.java17.sealedclasses.SealedSample.main(new String[]{});
       ```
# 08 | java9 / process manager
     - current process info
     - iterating on handles / pstree
     - killing processes + children
     - working with input / output of processes
       + call java process with java path/to/source/file.java

# 09 | java11 / string
     - lines
     - strip 
     - repeat

# 10 | java11 / file methods
    - readString
        -> read own source code




