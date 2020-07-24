package bookstore.shop.service.impl;

import bookstore.shop.model.entity.Order;
import bookstore.shop.repository.OrderRepository;
import bookstore.shop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Order findById(String id) {
        return this.modelMapper.map(this.orderRepository.findById(id), Order.class);
    }

    @Override
    public List<Order> allOrders() {
        return this.orderRepository.findAll();
    }
}
