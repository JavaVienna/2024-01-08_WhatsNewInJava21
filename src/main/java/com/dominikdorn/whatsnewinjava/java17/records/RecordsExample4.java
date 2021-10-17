package com.dominikdorn.whatsnewinjava.java17.records;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecordsExample4 {

  record Salesman(int id, String name) {

  }

  record Product(int id, String label, double price) {

  }

  record Sale(int merchant_id, int product_id) {

  }


  static Stream<Salesman> getMerchants() {
    return Stream.of(
        new Salesman(1, "Dominik"),
        new Salesman(2, "Sigi"),
        new Salesman(3, "Maxi"),
        new Salesman(4, "Daniel")
    );
  }

  static Stream<Product> getProducts() {
    return Stream.of(
        new Product(1, "Cola", 1.79),
        new Product(2, "Red Bull", 5.37),
        new Product(3, "Römerquelle", 0.97),
        new Product(4, "Highland Park", 38)
    );
  }

  static Stream<Sale> getSales() {
    return Stream.of(
        new Sale(1, 1),
        new Sale(1, 1),
        new Sale(1, 1),
        new Sale(2, 3),
        new Sale(2, 3),
        new Sale(2, 3),
        new Sale(2, 3),
        new Sale(2, 3),
        new Sale(2, 3),
        new Sale(3, 2),
        new Sale(3, 2),
        new Sale(4, 4)
    );
  }

  static void report() {

    record MerchantSales(int merchantId, String merchantName, Double sales) {
    }

    var productMap = getProducts().collect(Collectors.toMap(p -> p.id, p -> p));

    getMerchants().map(merchant ->
            new MerchantSales(
                merchant.id,
                merchant.name,
                getSales()
                    .filter(s -> s.merchant_id == merchant.id)
                    .map(sale -> productMap.get(sale.product_id).price)
                    .mapToDouble(Double::doubleValue)
                    .sum()
            )
        )
        .sorted(Comparator.comparingDouble(o -> o.sales))
        .forEach(RecordsExample4::println);

  }

  public static void main(String[] args) {
    report();
//    Comparator<MerchantSales> sortSales = Comparator.comparingDouble(o -> o.sales);
//    var highestFirst = sortSales.reversed();

  }

  static void println(Object o) {
    System.out.println(o);
  }


}
