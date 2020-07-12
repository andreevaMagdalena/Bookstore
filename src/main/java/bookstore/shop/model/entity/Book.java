package bookstore.shop.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.*;
import java.math.BigDecimal;
import java.util.Set;



@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book extends BaseEntity {
    @OneToMany
    private Set<Author> author;
    @Column
    private String ISBN;
    @Column
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private BigDecimal price;
    @Column
    private ImageIcon image;
    @Column
    private int year;
    @ManyToOne
    private Publisher publisher;
    @OneToMany
    private Set<Category> category;
    @Column
    private String languages;
    @ManyToOne
    private Order order;



}
