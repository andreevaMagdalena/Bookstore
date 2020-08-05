package bookstore.shop.web;

import bookstore.shop.model.binding.AuthorAddBindingModel;
import bookstore.shop.model.binding.CategoryAddBindingModel;
import bookstore.shop.model.binding.UserRegisterBindingModel;
import bookstore.shop.model.service.AuthorServiceModel;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model){
        if (!model.containsAttribute("categoryAddBindingModel")){
            model.addAttribute("categoryAddBindingModel", new CategoryAddBindingModel());
        }
        return "add-category";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("categoryAddBindingModel")CategoryAddBindingModel categoryAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("categoryAddBindingModel" ,categoryAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.categoryAddBindingModel", bindingResult);
            return "add-category";
        }
        this.categoryService.addCategory(this.modelMapper.map(categoryAddBindingModel, CategoryServiceModel.class));
        return "redirect:/";
    }
}
