package bookstore.shop.service;

import bookstore.shop.model.entity.Order;
import bookstore.shop.model.service.OrderServiceModel;

import java.util.List;

public interface OrderService {
   Order findById(String id);
   List<Order> allOrders();
   void addOrder(OrderServiceModel orderServiceModel);

}
