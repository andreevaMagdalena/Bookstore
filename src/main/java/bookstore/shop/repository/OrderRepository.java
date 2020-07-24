package bookstore.shop.repository;

import bookstore.shop.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface OrderRepository  extends JpaRepository<Order, String> {
    @Override
    Optional<Order> findById(String s);
}
