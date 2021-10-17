package com.dominikdorn.whatsnewinjava.java9.processmanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProcessManagerSample {

  //<editor-fold desc="current process info">
  static void printCurrentProcessInfo() {
    var handle = ProcessHandle.current();
    println("current pid: " + handle.pid());
    println("current command line: " + handle.info().commandLine());
    println("current command: " + handle.info().command());
    println("current arguments: " + handle.info().arguments());
    println("jvm running since: " + handle.info().startInstant());
  }
  //</editor-fold>



  //<editor-fold desc="pstree">
  static void psTree() {
    var rootProcesses = ProcessHandle.allProcesses().filter(x -> x.parent().isEmpty());
    rootProcesses.forEach(p -> printProcessTree(p, 0));
  }
  static void printProcessTree(ProcessHandle handle, int level) {
    print("  ".repeat(level));
    println(": " + handle.pid() + ": " + handle.info().command());
    handle
        .children()
        .filter(c -> c.info().command().isPresent())
        .forEach(c -> printProcessTree(c, level+1));
  }
  //</editor-fold>

  //<editor-fold desc="kill with children">
  static void killWithChildren(ProcessHandle handle){
    handle.children().forEach(c -> c.destroy());
    handle.destroy();
  }
  //</editor-fold>

  //<editor-fold desc="spawn process">
  static void createProcess(String cmd, List<String> args) throws IOException, InterruptedException {
    var list = new ArrayList<String>();
    list.add(cmd);
    list.addAll(args);
    ProcessBuilder builder = new ProcessBuilder(list);
    builder.directory(new File("."));
    builder.environment().remove("_JAVA_OPTIONS");
    var process = builder.start();
    var i = 0;
    var t = new Thread(() -> {
      var stream = process.getInputStream();
      byte[] buffer = new byte[1024];
      int x = 0;
      try {
        while((x = stream.read()) != -1) {
          print((char) x);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    t.start();
    while(i < 10) {
      println(process.pid() +":"+process.info().commandLine() + "  - isAlive?" + process.isAlive());
      Thread.sleep(1000L);
      i++;

    }
    process.destroy();
    process.waitFor(); // block

    println(process.pid() +":"+process.info().commandLine() + "  - isAlive?" + process.isAlive());
  }
  //</editor-fold>

  public static void main(String[] args) throws IOException, InterruptedException {

    printCurrentProcessInfo();
//    psTree();

//    killWithChildren(ProcessHandle.current());

//    createProcess("java", List.of(
//        "/Users/domdorn/jsug/whatsnewinjava/src/main/java/com/dominikdorn/whatsnewinjava/java9/processmanager/Loop.java"));
  }

  private static void print(Object o) { System.out.print(o);}
  private static void println(Object o) {
    System.out.println(o);
  }
}
