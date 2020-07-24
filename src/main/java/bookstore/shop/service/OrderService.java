package bookstore.shop.service;

import bookstore.shop.model.entity.Order;

import java.util.List;

public interface OrderService {
   Order findById(String id);
   List<Order> allOrders();

}
