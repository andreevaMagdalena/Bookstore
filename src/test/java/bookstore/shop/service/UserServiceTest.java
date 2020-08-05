package bookstore.shop.service;

import bookstore.shop.model.entity.Category;
import bookstore.shop.model.entity.User;
import bookstore.shop.model.service.CategoryServiceModel;
import bookstore.shop.model.service.UserServiceModel;
import bookstore.shop.repository.UserRepository;
import bookstore.shop.service.impl.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private  ModelMapper modelMapper;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    @Test
    public void shouldSavedUserSuccessFully(){
        User user = new User();
        user.setUsername("magi");
        user.setPassword("1234");
        user.setEmail("magi@abv.bg");
        user.setAddress("addres");
        user.setPhone("99999999");

        // Arrange
        Mockito.when(this.userRepository.findByUsername(user.getUsername())).thenReturn(Optional.empty());
        Mockito.when(userRepository.save(user)).thenAnswer(InvocationOnMock::getArguments);

        UserServiceModel savedUser = userService.register(this.modelMapper.map(user, UserServiceModel.class));

        Assert.assertNull(savedUser);



    }

    @Test
    public void getByName_whenNameIsCorrect_shouldReturnUser() {
        User user = new User();
        user.setUsername("magi");
        when(userRepository.findByUsername("magi"))
                .thenReturn(Optional.of(user));
        UserServiceModel userServiceModel = userService.findByUsername("magi");
        Assert.assertEquals("magi", userServiceModel.getUsername());

    }
}
