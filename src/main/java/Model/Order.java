package Model;

import java.sql.Timestamp;
import java.time.LocalDate;

public record Order(int id, LocalDate  date, double price) {
}

//    Orders should have an order ID, date, and total price.
