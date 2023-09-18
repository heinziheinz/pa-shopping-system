package service;

import Model.Order;
import Model.Product;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShoppingSystem {
//    all products with a price less than a certain amount

    public List<Product> allProductsWithLessPriceThanCertainAmount(double certainAmount, List<Product> products) {

        return products.stream().filter(product -> product.price() < certainAmount).toList();
    }

    public int witchCustomerSpentTheMost(List<Order> orders) {


        // Calculate the start of the last month
        LocalDate today = LocalDate.now();
        LocalDate startOfLastMonth = today.minusMonths(1).withDayOfMonth(1).minusDays(1);
        LocalDate startOfCurrentMonth = today.withDayOfMonth(1);

        Map<Integer, Double> allOrders = orders.stream()
                .filter(order -> order.date().getMonth().equals(LocalDate.now().getMonth().minus(1)))
                .collect(Collectors.groupingBy(
                        Order::id,
                        Collectors.summingDouble(Order::price)
                ));

        return allOrders.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(0);
    }

    public Product boughtMostly( List<Product> products  ){
       return products.stream().max(Comparator.comparing(Product::HowTimesProductWasBought)).orElse(null);
    }
}
