package bookstore.shop.service;

import bookstore.shop.model.entity.Book;
import bookstore.shop.model.service.BookServiceModel;
import bookstore.shop.model.view.BookViewModel;

import java.util.List;

public interface BookService {
      void  addBook(BookServiceModel bookServiceModel);
      List<BookViewModel> allBooks();
      BookViewModel findById(String id);
      void delete(String id);
      BookServiceModel findByName(String name);
}
