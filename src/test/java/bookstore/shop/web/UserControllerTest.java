package bookstore.shop.web;


import bookstore.shop.model.entity.Role;
import bookstore.shop.model.entity.User;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.model.service.UserServiceModel;
import bookstore.shop.repository.UserRepository;
import bookstore.shop.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    UserService userService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserRepository userRepository;

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



    @BeforeEach
    public void setUp() {

        userRepository.deleteAll();

        User user = new User();
        Role userRoleUser = new Role("ROLE_USER");
        userRoleUser.setName(userRoleUser.getName());

        Role userRoleAdmin = new Role("ROLE_ADMIN");
        userRoleAdmin.setName(userRoleAdmin.getName());



        user.setUsername("Pesho");
        user.setPassword("123");
        user.setEmail("pesho@pesho.com");
        user.setRole(userRoleAdmin);
        user.setAddress("Sofiq");
        user.setPhone("0897755444");


        this.userRepository.saveAndFlush(user);

    }

    @AfterEach
    public void setDown() {
        this.userRepository.deleteAll();
    }



    @Test
    public void should_Return_Register_Page() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("/register"))
                .andExpect(model().attributeExists("userRegisterBindingModel"));
    }

    @Test
    public void should_Create_New_User() throws Exception {
        //act
        mockMvc.perform(MockMvcRequestBuilders
                .post("/users/register")
                .with(csrf())
                .param("username", "Ignat")
                .param("email", "Ignat@Ignat.com")
                .param("password", "123")
                .param("confirmPassword", "123")
        ).andExpect(status().is3xxRedirection());

        //assert
        Assertions.assertEquals(2, this.userRepository.count());
    }
/*
    @Test
    public void should_Not_Create_New_User_With_Wrong_Params() throws Exception {
        //act
        mockMvc.perform(MockMvcRequestBuilders
                .post("/users/register")
                .with(csrf())
                .param("username", "Ignat")
                .param("email", "IgnatIgnat.com")
                .param("password", "123")
                .param("confirmPassword", "123")
        ).andExpect(status().is3xxRedirection());

        //assert
        Assertions.assertEquals(1, this.userEntityRepository.count());
    }

*/

    @Test
    public void should_Return_Login_Page() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("/login"));
    }
/*
    @Test
    public void should_Return_User_Details_Page() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/details").
                        with(username("Pesho").password("123").roles("USER","ADMIN")))
                .andExpect(status().isOk())
                .andExpect(view().name("user/details-user"))
                .andExpect(model().attributeExists("user"));
    }
*/






}
