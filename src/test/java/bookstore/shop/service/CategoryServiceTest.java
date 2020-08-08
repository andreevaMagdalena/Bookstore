package bookstore.shop.service;


import bookstore.shop.model.binding.CategoryAddBindingModel;
import bookstore.shop.model.entity.Category;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.model.service.UserServiceModel;
import bookstore.shop.repository.CategoryRepository;



import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class CategoryServiceTest  {

    private static final String VALID_CATEGORY_NAME = "comedy";
    private static final String VALID_CATEGORY_NEW_NAME = "action";
    private static final String VALID_ID = "aaaaaaaa";

    @MockBean
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;
    @Before
    public void setUp() {
        Category test = new Category();
        test.setCategoryName("comedy");
        Mockito.when(categoryRepository.findByCategoryName(test.getCategoryName()))
                .thenReturn(Optional.of(test));
    }
    @Test
    public void getByName_whenNameIsCorrect_shouldReturnCategory() {

        Category category = new Category();
        category.setCategoryName("action");

        when(categoryRepository.findByCategoryName("action"))
                .thenReturn(Optional.of(category));

        CategoryServiceModel categoryServiceModel = categoryService.findByName("action");

        Assert.assertEquals("action", categoryServiceModel.getCategoryName());
    }
    @Test
    public void addCategory_whenNameIsCorrect() {

        CategoryServiceModel category = new CategoryServiceModel("category", "ddddd");

        categoryService.addCategory(category);

        Assert.assertEquals("category", category.getCategoryName());
    }
    @Test(expected = NullPointerException.class)
    public void addCategory_whenNameIsNotCorrect() {

        CategoryServiceModel category = new CategoryServiceModel("category", "ddddd");

        categoryService.addCategory(category);

        Assert.assertEquals("category2", category.getCategoryName());
    }




}

