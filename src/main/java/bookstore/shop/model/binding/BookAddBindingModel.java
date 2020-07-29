package bookstore.shop.model.binding;

import bookstore.shop.model.service.AuthorServiceModel;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.model.service.PublisherServiceModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookAddBindingModel {
    private String author;
    private String ISBN;
    private String title;
    private String description;
    private BigDecimal price;
    private int year;
    private String publisher;
    private String category;
    private String languages;

}
