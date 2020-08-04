package bookstore.shop.web;

import bookstore.shop.model.binding.BookAddBindingModel;
import bookstore.shop.model.binding.OrderAddBindingModel;
import bookstore.shop.model.service.*;
import bookstore.shop.service.BookService;
import bookstore.shop.service.OrderService;
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
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final BookService bookService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, BookService bookService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public String addOrder(Model model){
        model.addAttribute("books", bookService.allBooks());
        return "order-details";
    }
    @PostMapping("/list")
    public String addConfirm(@Valid @ModelAttribute("orderAddBindingModel")OrderAddBindingModel orderAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        BookServiceModel book = this.bookService.findByName(orderAddBindingModel.getBook().getTitle());
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("orderAddBindingModel" ,orderAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);
            return "order-details";
        }
        OrderServiceModel order = this.modelMapper.map(orderAddBindingModel, OrderServiceModel.class);
        order.setBook(book);

        this.orderService.addOrder(order);

        return "redirect:/";
    }

}
