package bookstore.shop.web;

import bookstore.shop.model.binding.CategoryAddBindingModel;
import bookstore.shop.model.binding.PublisherAddBindingModel;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.model.service.PublisherServiceModel;
import bookstore.shop.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/publishers")
public class PublisherController {
private final PublisherService publisherService;
private final ModelMapper modelMapper;

    public PublisherController(PublisherService publisherService, ModelMapper modelMapper) {
        this.publisherService = publisherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(){
        return "add-publisher";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("publisherAddBindingModel") PublisherAddBindingModel publisherAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "add-category";
        }
        this.publisherService.addPublisher(this.modelMapper.map(publisherAddBindingModel, PublisherServiceModel.class));
        return "redirect:/index";
    }
}
