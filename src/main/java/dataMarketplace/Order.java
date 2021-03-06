package dataMarketplace;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
    @Id
    private int orderID;
    @Column(nullable = false)
    private int customerID;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private boolean state;

    public Order(){}
    public Order(int orderID,int customerID, String description, boolean state){
        this.orderID = orderID;
        this.customerID = customerID;
        this.description = description;
        this.state = state;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
