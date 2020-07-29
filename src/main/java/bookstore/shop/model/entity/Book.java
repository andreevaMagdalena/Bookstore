package bookstore.shop.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.math.BigDecimal;




@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;
    @Column
    private String ISBN;
    @Column
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private BigDecimal price;
    @Column
    private int year;
    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @Column
    private String languages;


}
