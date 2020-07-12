package bookstore.shop.web;

import bookstore.shop.model.binding.BookAddBindingModel;
import bookstore.shop.model.service.BookServiceModel;
import bookstore.shop.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final ModelMapper modelMapper;


    public BookController(BookService bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/add")
    public String add(){
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("bookAddBindingModel") BookAddBindingModel bookAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            return "redirect:add";
        }
        this.bookService.addBook(this.modelMapper.map(bookAddBindingModel, BookServiceModel.class));
        return "redirect:/";
    }
    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") String id, ModelAndView modelAndView){
        modelAndView.addObject("item", this.bookService.findById(id));
        modelAndView.setViewName("details-item");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        this.bookService.delete(id);
        return "redirect:/";
    }

}
