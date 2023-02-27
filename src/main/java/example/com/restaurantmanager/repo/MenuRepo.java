package example.com.restaurantmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import example.com.restaurantmanager.model.Menu;

import java.util.Optional;

public interface MenuRepo extends JpaRepository<Menu, Long> {
    void deleteMenuById(Long id);
    Optional<Menu> findMenuById(Long id);

}
