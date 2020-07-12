package bookstore.shop.service;

import bookstore.shop.model.entity.Role;

public interface RoleService {
    Role findByName(String name);

}
