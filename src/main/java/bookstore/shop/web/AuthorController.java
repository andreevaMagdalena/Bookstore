package bookstore.shop.web;

import bookstore.shop.model.binding.AuthorAddBindingModel;
import bookstore.shop.model.binding.UserRegisterBindingModel;
import bookstore.shop.model.service.AuthorServiceModel;
import bookstore.shop.model.service.BookServiceModel;
import bookstore.shop.service.AuthorService;
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
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    public AuthorController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String addAuthor(Model model){
        if (!model.containsAttribute("authorAddBindingModel")){
            model.addAttribute("authorAddBindingModel", new AuthorAddBindingModel());
        }
        return "add-author";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("authorAddBindingModel")AuthorAddBindingModel authorAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "add-author";
        }
        this.authorService.addAuthor(this.modelMapper.map(authorAddBindingModel, AuthorServiceModel.class));
        return "redirect:/";
    }


}
