package bookstore.shop.model.service;


import bookstore.shop.model.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookServiceModel {

    private AuthorServiceModel author;

    private String ISBN;

    private String title;

    private String description;

    private BigDecimal price;

    private int year;

    private PublisherServiceModel publisher;

    private CategoryServiceModel category;

    private String languages;


}
