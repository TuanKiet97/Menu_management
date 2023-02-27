package example.com.restaurantmanager.service;

import example.com.restaurantmanager.repo.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.com.restaurantmanager.exception.UserNotFoundException;
import example.com.restaurantmanager.model.Bill;

import java.util.List;

@Service
public class BillService {
    private final BillRepo billRepo;

    @Autowired
    public BillService(BillRepo billRepo){
        this.billRepo = billRepo;
    }
    public Bill addBill(Bill bill){
        return billRepo.save(bill);
    }
    public List<Bill> findAllBill(){
        return billRepo.findAll();
    }
    public Bill updateBill(Bill bill){
        return billRepo.save(bill);
    }
    public Bill findBillById(Long id){
        return billRepo.findBillById(id)
                .orElseThrow(()->new UserNotFoundException("Menu by id "+ id + "was not foud"));
    }
    public void deleteBill(Long id){
        billRepo.deleteById(id);
    }
}
