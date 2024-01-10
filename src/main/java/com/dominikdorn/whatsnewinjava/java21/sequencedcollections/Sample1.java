package com.dominikdorn.whatsnewinjava.java21.sequencedcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class Sample1 {

  public static void main(String[] args) {
    var list = List.of(1,2,3,4,5,6,7,8,9,10);

    System.out.println(list instanceof SequencedCollection<?>);

    System.out.println("list.getLast() = " + list.getLast());
    System.out.println("list.getFirst() = " + list.getFirst());

    System.out.println("ArrayList:");
    var arrayList = new ArrayList<>();
    arrayList.addAll(List.of(1,2,3,4,5,6,7,8));
    System.out.println("arrayList.getFirst() = " + arrayList.getFirst());
    arrayList.addFirst(0);
    System.out.println("arrayList.getFirst() = " + arrayList.getFirst());
  }
}
