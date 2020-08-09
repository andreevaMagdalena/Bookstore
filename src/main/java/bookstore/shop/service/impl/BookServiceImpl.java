package bookstore.shop.service.impl;


import bookstore.shop.model.entity.Book;

import bookstore.shop.model.service.BookServiceModel;

import bookstore.shop.model.view.BookViewModel;
import bookstore.shop.repository.BookRepository;
import bookstore.shop.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
        Book book = this.bookRepository.findByTitle(bookServiceModel.getTitle()).orElse(null);

        if (book != null){
            throw new IllegalArgumentException("Book already exists");
        }

       this.bookRepository.saveAndFlush(this.modelMapper
               .map(bookServiceModel, Book.class));

    }

    @Override
    public List<BookViewModel> allBooks() {
        return this.bookRepository.findAll().stream().map(book -> {
            BookViewModel bookViewModel = this.modelMapper
                    .map(book, BookViewModel.class);
            bookViewModel.setImgUrl(String.format("/img/%s.jpg",
                    book.getCategory().getCategoryName()));
            return bookViewModel;
        }).collect(Collectors.toList());
    }

    @Override
    public BookViewModel findById(String id) {
        return this.bookRepository.findById(id).map(book -> {
            BookViewModel bookViewModel = this.modelMapper
                    .map(book, BookViewModel.class);
            bookViewModel.setImgUrl(String.format("/img/%s.jpg", book.getCategory().getCategoryName()));
            return bookViewModel;
        }).orElse(null);
    }

    @Override
    public void delete(String id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public BookServiceModel findByName(String name) {
        return this.bookRepository.findByTitle(name)
                .map(b -> this.modelMapper.map(b, BookServiceModel.class)).orElse(null);
    }
}
