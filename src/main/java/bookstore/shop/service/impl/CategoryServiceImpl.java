package bookstore.shop.service.impl;

import bookstore.shop.model.entity.Category;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.repository.CategoryRepository;
import bookstore.shop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Category findById(String id) {
        return this.modelMapper.map(this.repository.findById(id), Category.class);
    }


    @Override
    public List<Category> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void addCategory(CategoryServiceModel categoryServiceModel) {
        Category category = this.modelMapper.map(categoryServiceModel, Category.class);
        this.repository.saveAndFlush(category);

    }
}
