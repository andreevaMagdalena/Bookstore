package bookstore.shop.service.impl;

import bookstore.shop.model.entity.Author;
import bookstore.shop.model.service.AuthorServiceModel;
import bookstore.shop.repository.AuthorRepository;
import bookstore.shop.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addAuthor(AuthorServiceModel author) {
        Author newAuthor = this.modelMapper.map(author, Author.class);
        this.repository.saveAndFlush(newAuthor);

    }

    @Override
    public List<String> getAuthors() {
        return
                this.repository.findAll().stream().map(Author::getFirstName).collect(Collectors.toList());
    }

    @Override
    public AuthorServiceModel getById(String id) {
        return this.modelMapper.map(this.repository.findById(id), AuthorServiceModel.class);
    }

    @Override
    public AuthorServiceModel getByName(String name) {
        return this.repository.findByFirstName(name).map(n ->
               this.modelMapper.map(n, AuthorServiceModel.class)).orElse(null);
    }
}
