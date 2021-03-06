package bookstore.shop.service;


import bookstore.shop.model.entity.Category;
import bookstore.shop.model.service.CategoryServiceModel;

import java.util.List;

public interface CategoryService {
   Category findById(String id);
   List<String> findAll();
   void addCategory(CategoryServiceModel categoryServiceModel);
   CategoryServiceModel findByName(String name);
}
