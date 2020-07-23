package bookstore.shop.web;


import bookstore.shop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
   private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
