package bookstore.shop.service;

import bookstore.shop.model.entity.Author;
import bookstore.shop.model.service.AuthorServiceModel;

import java.util.List;

public interface AuthorService {
    void addAuthor(AuthorServiceModel author);
    List<String> getAuthors();
    AuthorServiceModel getById(String id);
    AuthorServiceModel getByName(String name);

}
