package bookstore.shop.web;

import bookstore.shop.model.binding.BookAddBindingModel;
import bookstore.shop.model.entity.Author;
import bookstore.shop.model.service.AuthorServiceModel;
import bookstore.shop.model.service.BookServiceModel;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.model.service.PublisherServiceModel;
import bookstore.shop.service.AuthorService;
import bookstore.shop.service.BookService;
import bookstore.shop.service.CategoryService;
import bookstore.shop.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final CategoryService categoryService;


    public BookController(BookService bookService, ModelMapper modelMapper, PublisherService publisherService, AuthorService authorService, CategoryService categoryService) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }
    @GetMapping("/add")
    public String add(Model model){
        if (!model.containsAttribute("bookAddBindingModel")){
            model.addAttribute("bookAddBindingModel", new BookAddBindingModel());
        }
        model.addAttribute("allPublishers", this.publisherService.findAll());
        model.addAttribute("allAuthors", this.authorService.getAuthors());
        model.addAttribute("allCategories", this.categoryService.findAll());
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("bookAddBindingModel") BookAddBindingModel bookAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        AuthorServiceModel author = this.authorService.getByName(bookAddBindingModel.getAuthor());
        PublisherServiceModel publisher = this.publisherService.findByName(bookAddBindingModel.getPublisher());
        CategoryServiceModel category = this.categoryService.findByName(bookAddBindingModel.getCategory());
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("bookAddBindingModel" ,bookAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bookAddBindingModel", bindingResult);
            return "add-item";
        }

        BookServiceModel book = this.modelMapper.map(bookAddBindingModel, BookServiceModel.class);
        book.setAuthor(author);
        book.setCategory(category);
        book.setPublisher(publisher);
        this.bookService.addBook(book);

        return "redirect:/";
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") String id, ModelAndView modelAndView){
        modelAndView.addObject("books", this.bookService.findById(id));
        modelAndView.setViewName("details-item");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        this.bookService.delete(id);
        return "redirect:/";
    }



}
