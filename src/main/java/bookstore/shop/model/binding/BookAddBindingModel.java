package bookstore.shop.model.binding;

import bookstore.shop.model.entity.Author;
import bookstore.shop.model.entity.Category;
import bookstore.shop.model.entity.Order;
import bookstore.shop.model.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookAddBindingModel {
    private Author author;
    private String ISBN;
    private String title;
    private String description;
    private BigDecimal price;
    private ImageIcon image;
    private int year;
    private Publisher publisher;
    private Category category;
    private String languages;

}
