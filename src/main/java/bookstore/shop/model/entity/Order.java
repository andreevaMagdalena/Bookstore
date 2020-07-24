package bookstore.shop.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity {
    @OneToMany
    private Set<Book> book;
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
