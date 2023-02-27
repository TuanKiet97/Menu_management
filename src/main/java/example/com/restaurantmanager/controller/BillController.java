package example.com.restaurantmanager.controller;

import example.com.restaurantmanager.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import example.com.restaurantmanager.model.Bill;


import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bill>> getAllBill() {
        List<Bill> bills = billService.findAllBill();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") Long id) {
        Bill bill = billService.findBillById(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {
        Bill newBill = billService.addBill(bill);
        return new ResponseEntity<>(newBill, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) {
        Bill updateBill = billService.updateBill(bill);
        return new ResponseEntity<>(updateBill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable("id") Long id) {
        billService.deleteBill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
