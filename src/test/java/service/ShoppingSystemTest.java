package service;

import Model.Order;
import Model.Product;
import Model.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingSystemTest {


    ShoppingSystem shoppingSystem;
    Product productOne;
    Product productTwo;
    Product productThree;

    Order orderOne;
    Order orderTwo;
    Order orderThree;
    Order orderFour;


    @BeforeEach
    void setUp() {
        shoppingSystem = new ShoppingSystem();
        productOne = new Product(1, "Chair", 150, ProductType.TECHNICAL, 3);

        // Create more products
        productTwo = new Product(2, "Table", 200, ProductType.TECHNICAL, 5);
        productThree = new Product(3, "Shirt", 30, ProductType.CLOTH, 10);
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LocalDate localDateOne = LocalDate.of(2023, 8, 1);
        orderOne = new Order(1,  localDateOne , 20000);

        LocalDate localDateTwo = LocalDate.of(2023, 8, 18);
        orderTwo = new Order(2, localDateTwo, 500.00);

        LocalDate localDateThrre = LocalDate.of(2023, 9, 18);
        orderThree = new Order(3, localDateThrre, 300.00);

        LocalDate localDatefour = LocalDate.of(2023, 8, 18);
        orderFour = new Order(2, localDatefour, 400.00);
    }

    @Test
    void allProductsWithLessPriceThanCertainAmount() {
        List<Product> products = List.of(productOne, productTwo, productThree);
        List<Product> allProducts = shoppingSystem.allProductsWithLessPriceThanCertainAmount(1000.00, products);
        System.out.println("allProducts = " + allProducts);
        assertEquals(3, allProducts.size());
    }

    @Test
    void witchCustomerSpentTheMost() {

        List<Order> orders = List.of(orderOne, orderTwo, orderThree, orderFour);
        int customer = shoppingSystem.witchCustomerSpentTheMost(orders);
        System.out.println("customer = " + customer);
        assertEquals(orderOne.id(),customer );
    }
    @Test
    void boughtMostly(){

        List<Product> products = List.of(productOne, productTwo, productThree);
        Product actual = shoppingSystem.boughtMostly(products);
        assertEquals(productThree, actual);
    }
}


