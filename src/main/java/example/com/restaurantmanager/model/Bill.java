package example.com.restaurantmanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String item;
    private Long quantity;
    private double totalPrice;
    private String date;

    public Bill() {
    }

    public Bill(Long id, String item, Long quantity, double totalPrice, String date) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public Bill(String item, Long quantity, double totalPrice, String date) {
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", date=" + date +
                '}';
    }
}
