package bookstore.shop.service.impl;

import bookstore.shop.model.entity.Book;
import bookstore.shop.model.entity.Category;
import bookstore.shop.model.entity.Publisher;
import bookstore.shop.model.service.BookServiceModel;
import bookstore.shop.repository.BookRepository;
import bookstore.shop.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final CategoryService categoryService;
    private final OrderService orderService;



    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, AuthorService authorService, PublisherService publisherService, CategoryService categoryService, OrderService orderService) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.categoryService = categoryService;
        this.orderService = orderService;
    }

    @Override
    public void addBook(BookServiceModel bookServiceModel) {
        Book book = this.modelMapper.map(bookServiceModel, Book.class);
        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> allBooks() {
       return this.bookRepository.findAll();
    }

    @Override
    public BookServiceModel findById(String id) {
        return this.modelMapper.map(this.bookRepository.findById(id), BookServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.bookRepository.deleteById(id);
    }
}
