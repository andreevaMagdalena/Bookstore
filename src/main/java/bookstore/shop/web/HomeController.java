package bookstore.shop.web;


import bookstore.shop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/index")
public class HomeController {
   private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/")
    public String index(){
        return "index";
    }
}
