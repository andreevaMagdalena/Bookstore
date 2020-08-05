package bookstore.shop.model.binding;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddBindingModel {
    @NotNull(message = "Must choose a book")
    private String book;
    @NotNull(message = "Date is required")
    private String orderDate;
    @DecimalMin(value = "0", message = "Price can not be negative value")
    private BigDecimal price;
    @NotNull(message = "Information is required")
    private String shoppingInfo;
    @NotNull(message = "Method is required")
    private String paymentMethod;
    @NotNull(message = "Address is required")
    private String address;
}
