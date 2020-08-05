package bookstore.shop.service.impl;



import bookstore.shop.model.entity.User;
import bookstore.shop.model.service.UserServiceModel;
import bookstore.shop.repository.UserRepository;
import bookstore.shop.service.RoleService;
import bookstore.shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        userServiceModel.setRole(this.roleService.findByName(
                this.userRepository.count() == 0 ? "ADMIN" : "USER"));
       User user = this.modelMapper.map(userServiceModel, User.class);
        user.setPassword(this.bCryptPasswordEncoder.encode(userServiceModel.getPassword()));
       return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findById(String id) {
        return this.userRepository.findById(id).map(user -> this.modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userRepository.findByUsername(username).map(user ->
            this.modelMapper.map(user, UserServiceModel.class)
        ).orElse(null);
    }
}
