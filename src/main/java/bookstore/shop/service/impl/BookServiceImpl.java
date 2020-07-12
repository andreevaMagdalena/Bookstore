package bookstore.shop.service.impl;

import bookstore.shop.model.entity.Book;
import bookstore.shop.model.service.BookServiceModel;
import bookstore.shop.repository.BookRepository;
import bookstore.shop.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addBook(BookServiceModel bookServiceModel) {
        Book book = this.modelMapper.map(bookServiceModel, Book.class);

    }

    @Override
    public List<BookServiceModel> allBooks() {
        return null;
    }

    @Override
    public BookServiceModel findById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {
        this.bookRepository.deleteById(id);
    }
}
