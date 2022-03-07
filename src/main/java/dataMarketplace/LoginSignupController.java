package dataMarketplace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class LoginSignupController extends HttpServlet {
    HashMap<Integer, Owner> ownerList = new HashMap<>();
    HashMap<Integer, Customer> customerList = new HashMap<>();
    int count = 0;
    @GetMapping("/login-owner")
    public String loginOwner() {
        return "login-owner.html";
    }
    @PostMapping("/login-owner")
    public void loginOwner(Owner data, HttpServletResponse response) {
        for (int i = 0; i < count; i++) {
            String inEmail;
            String inPassword;
            inEmail = ownerList.get(i).getEmail();
            inPassword = ownerList.get(i).getPassword();
            if (Objects.equals(data.getEmail(), inEmail) && Objects.equals(data.getPassword(), inPassword)) {
                try {
                    response.sendRedirect("/owner-index");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            else{
                try {
                    response.sendRedirect("/login-error-page");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
    @GetMapping("/login-customer")
    public String loginCustomer() {
        return "login-customer.html";
    }

    @GetMapping("/signup-owner")
    public String signupOwner() {
        return "signup-owner.html";
    }

    @PostMapping("/signup-owner")
    public void addOwner(Owner data, HttpServletResponse response) {
        data.setOwnerId(count);
        ownerList.put(count, data);
        count++;
        try {
            response.sendRedirect("/owner-index");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/signup-customer")
    public String signupCustomer() {
        return "signup-customer.html";
    }
    @PostMapping("/signup-customer")
    public void addCustomer(Customer data, HttpServletResponse response) {
        data.setCustomerId(count);
        customerList.put(count, data);
        count++;
        try {
            response.sendRedirect("/owner-index");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
