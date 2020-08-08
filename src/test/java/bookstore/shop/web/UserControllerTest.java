package bookstore.shop.web;


import bookstore.shop.model.entity.Role;
import bookstore.shop.model.entity.User;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.model.service.UserServiceModel;
import bookstore.shop.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    UserService userService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;
    @Test
    public void whenNullValue_thenReturns400() throws Exception {
        User user = new User();
        user.setEmail("zaphod@galaxy.net");

        mockMvc.perform(post("/users/register", 42L)
      .content(objectMapper.writeValueAsString(user)))
      .andExpect(status().isBadRequest());
    }
    @Test
    public void Register_whenNameIsCorrect() {
        Role role = new Role();

        UserServiceModel userServiceModel = new UserServiceModel(role, "ddddd","ddddd","magi@abv.bg","ddddd","ddddd");

        userService.register(userServiceModel);

        Assert.assertEquals("ddddd", userServiceModel.getUsername());
    }
    @Test(expected = NullPointerException.class)
    public void registerWithoutEmail(){
        UserServiceModel userServiceModel = new UserServiceModel();
        userServiceModel.setUsername("test user");
        userService.register(userServiceModel);
    }


}
