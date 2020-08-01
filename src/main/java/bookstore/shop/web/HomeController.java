package bookstore.shop.web;


import bookstore.shop.service.AuthorService;
import bookstore.shop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {
   private final BookService bookService;


    public HomeController(BookService bookService) {
        this.bookService = bookService;

    }


    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView){
        if (httpSession.getAttribute("user") == null){
            modelAndView.setViewName("index");
        }else {
            modelAndView.addObject("books", this.bookService.allBooks());
            modelAndView.setViewName("home");
        }

        return modelAndView;
    }

}
