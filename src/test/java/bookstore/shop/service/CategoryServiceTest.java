package bookstore.shop.service;


import bookstore.shop.model.entity.Category;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.model.service.UserServiceModel;
import bookstore.shop.repository.CategoryRepository;



import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
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
    @Autowired
    ModelMapper modelMapper;
    @Test
    public void getByName_whenNameIsCorrect_shouldReturnCategory() {

        Category category = new Category();
        category.setCategoryName("action");

        when(categoryRepository.findByCategoryName("action"))
                .thenReturn(Optional.of(category));

        CategoryServiceModel categoryServiceModel = categoryService.findByName("action");

        Assert.assertEquals("action", categoryServiceModel.getCategoryName());
    }


}

