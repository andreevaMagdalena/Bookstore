package bookstore.shop.service;


import bookstore.shop.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);
    UserServiceModel findById(String id);
    UserServiceModel findByUsername(String username);
}
