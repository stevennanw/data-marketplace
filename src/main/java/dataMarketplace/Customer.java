package dataMarketplace;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer implements Serializable{
    @Id
    //@GeneratedValue
    private int customerId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
