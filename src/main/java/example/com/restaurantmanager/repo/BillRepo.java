package example.com.restaurantmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import example.com.restaurantmanager.model.Bill;


import java.util.Optional;

public interface BillRepo extends JpaRepository<Bill, Long> {
    void deleteBillById(Long id);

    Optional<Bill> findBillById(Long id);

}
