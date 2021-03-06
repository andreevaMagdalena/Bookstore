package bookstore.shop.repository;

import bookstore.shop.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
    Optional<Author> findById(String id);
    Optional<Author> findByFirstName(String name);

}
