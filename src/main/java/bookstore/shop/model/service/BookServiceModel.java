package bookstore.shop.model.service;

import bookstore.shop.model.entity.Author;
import bookstore.shop.model.entity.Category;
import bookstore.shop.model.entity.Order;
import bookstore.shop.model.entity.Publisher;


import javax.swing.*;
import java.math.BigDecimal;
import java.util.Set;

public class BookServiceModel {

    private Set<Author> author;

    private String ISBN;

    private String title;

    private String description;

    private BigDecimal price;

    private ImageIcon image;

    private int year;

    private Publisher publisher;

    private Set<Category> category;

    private String languages;

    private Order order;
}
