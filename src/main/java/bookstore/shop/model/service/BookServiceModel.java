package bookstore.shop.model.service;

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
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookServiceModel {

    private Set<AuthorServiceModel> author;

    private String ISBN;

    private String title;

    private String description;

    private BigDecimal price;

    private String image;

    private int year;

    private PublisherServiceModel publisher;

    private Set<CategoryServiceModel> category;

    private String languages;

    private OrderServiceModel order;
}
