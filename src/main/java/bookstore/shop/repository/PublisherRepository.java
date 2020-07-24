package bookstore.shop.repository;

import bookstore.shop.model.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, String> {
    @Override
    Optional<Publisher> findById(String s);

    Publisher findByCompanyName(String name);
}
