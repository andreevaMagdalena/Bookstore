package bookstore.shop.service;

import bookstore.shop.model.entity.Book;
import bookstore.shop.model.service.BookServiceModel;

import java.util.List;

public interface BookService {
      void  addBook(BookServiceModel bookServiceModel);
      List<Book> allBooks();
      BookServiceModel findById(String id);
      void delete(String id);
}
