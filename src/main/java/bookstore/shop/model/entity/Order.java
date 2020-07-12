package bookstore.shop.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity {
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column
    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String shoppingInfo;
    @Column(name = "peyment_method")
    private String paymentMethod;
    @Column
    private String address;

}
