package bookstore.shop.model.service;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderServiceModel {
    @NotNull(message = "Must choose a book")
    private BookServiceModel book;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The order can not be in the past")
    private LocalDateTime orderDate;
    @DecimalMin(value = "0", message = "Price can not be negative value")
    private BigDecimal price;
    @NotNull(message = "Information is required")
    private String shoppingInfo;
    @NotNull(message = "Method is required")
    private String paymentMethod;
    @NotNull(message = "Address is required")
    private String address;
}
