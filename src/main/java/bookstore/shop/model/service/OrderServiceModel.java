package bookstore.shop.model.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderServiceModel {
    private LocalDateTime orderDate;

    private BigDecimal price;

    private String shoppingInfo;

    private String paymentMethod;

    private String address;
}
