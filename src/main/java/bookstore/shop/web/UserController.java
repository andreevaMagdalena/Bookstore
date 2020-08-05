package bookstore.shop.web;


import bookstore.shop.model.binding.UserLoginBindingModel;
import bookstore.shop.model.binding.UserRegisterBindingModel;
import bookstore.shop.model.service.UserServiceModel;
import bookstore.shop.model.view.UserProfileView;
import bookstore.shop.service.UserService;


import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @GetMapping("/profile")
    public String profile(@RequestParam("id") String id, Model model){
        model.addAttribute("user", this.modelMapper.map(this.userService.findById(id), UserProfileView.class));
        return "profile";
    }
   @GetMapping("/login")
    public String login(Model model){
        if (!model.containsAttribute("userLoginBindingModel")){
            model.addAttribute("userLoginBindingModel",new UserLoginBindingModel());
        }
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model){
        if (!model.containsAttribute("userRegisterBindingModel")){
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel")
                                          UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel");

            return "redirect:register";
        }
        if (userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            this.userService.register(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        }
        return "redirect:login";
    }
    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute() UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession httpSession){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel");
            return "login";
        }
        UserServiceModel user = this.userService.findByUsername(userLoginBindingModel.getUsername());
        if (user == null || !bCryptPasswordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())){
            redirectAttributes.addFlashAttribute("norFound", true);
            return "login";
        }
        httpSession.setAttribute("user", user);

        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }


}
