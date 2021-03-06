package bookstore.shop.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity {
    @OneToMany
    private List<Book> book;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column
    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String shoppingInfo;
    @Column(name = "peyment_method")
    @Enumerated(value = EnumType.STRING)
    private Payment paymentMethod;
    @Column
    private String address;

}
