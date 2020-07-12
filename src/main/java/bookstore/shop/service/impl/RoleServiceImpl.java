package bookstore.shop.service.impl;

import bookstore.shop.model.entity.Role;
import bookstore.shop.repository.RoleRepository;
import bookstore.shop.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }
    @PostConstruct
    public void init(){
        if(this.roleRepository.count() == 0){
            Role admin = new Role("ADMIN");
            Role user = new Role("USER");
            this.roleRepository.saveAndFlush(admin);
            this.roleRepository.saveAndFlush(user);
        }
    }
    @Override
    public Role findByName(String name) {
        return this.roleRepository.findByName(name).map(role ->
                this.modelMapper.map(role, Role.class)).orElse(null);
    }
}
