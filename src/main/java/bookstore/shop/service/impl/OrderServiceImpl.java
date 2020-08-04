package bookstore.shop.service.impl;

import bookstore.shop.model.entity.Order;
import bookstore.shop.model.service.OrderServiceModel;
import bookstore.shop.repository.OrderRepository;
import bookstore.shop.service.BookService;
import bookstore.shop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final BookService bookService;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, BookService bookService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.bookService = bookService;
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

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        this.orderRepository.save(this.modelMapper.map(orderServiceModel, Order.class));

    }
}
