package bookstore.shop.web;


import bookstore.shop.service.AuthorService;
import bookstore.shop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
   private final BookService bookService;
   private final AuthorService authorService;


    public HomeController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @GetMapping("/index")
    public String index(){
        return "index";
    }


}
