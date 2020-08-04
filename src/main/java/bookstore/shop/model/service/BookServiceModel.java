package bookstore.shop.model.service;


import bookstore.shop.model.entity.Author;
import bookstore.shop.model.entity.Category;
import bookstore.shop.model.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookServiceModel {

    @Length(min = 3, max = 20, message = "Author length must be between 3 and 20 characters (inclusive 3 and 20)")
    private AuthorServiceModel author;
    @NotNull(message = "ISBN is required")
    @Column(unique = true)
    private String ISBN;
    @Length(min = 2, max = 40, message = "Title length must be between 2 and 20 characters (inclusive 2 and 40)")
    private String title;
    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    private String description;
    @DecimalMin(value = "0", message = "Price must be a positive number")
    private BigDecimal price;
    @Min(value = 0,message = "Year must be a positive number")
    private int year;
    @NotNull(message = "Publisher is required")
    private PublisherServiceModel publisher;
    @NotNull(message = "Category is required")
    private CategoryServiceModel category;
    @NotNull(message = "Languages is required")
    private String languages;


}
