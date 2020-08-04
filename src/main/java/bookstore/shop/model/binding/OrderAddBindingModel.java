package bookstore.shop.model.binding;

import bookstore.shop.model.service.BookServiceModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddBindingModel {
    @NotNull(message = "Must choose a book")
    private BookServiceModel book;
    @NotNull(message = "Date is required")
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
