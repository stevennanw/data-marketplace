package dataMarketplace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class Customer_LoginSignupController extends HttpServlet {
    HashMap<Integer, Customer> customerList = new HashMap<>();

    public void setAdminCustomer(HashMap<Integer, Customer> customerList) {
        this.customerList = customerList;
        Customer admin = new Customer();
        admin.setEmail("admin@goosecity.com");
        admin.setPassword("goosecity");
        customerList.put(0,admin);
        count=1;
        admin_exist=1;
    }
    int count = 0;
    int admin_exist = 0;
    @GetMapping("/login-customer")
    public String loginCustomer() {
        return "login-customer.html";
    }

    @PostMapping("/login-customer")
    public void loginCustomer(Customer data, HttpServletResponse response) {
        if(admin_exist==0){
        setAdminCustomer(customerList);
        }
        for (int i = 0; i < count; i++) {
            String inEmail;
            String inPassword;
            inEmail = customerList.get(i).getEmail();
            inPassword = customerList.get(i).getPassword();

            if (Objects.equals(data.getEmail(), inEmail) && Objects.equals(data.getPassword(), inPassword)) {
                try {
                    response.sendRedirect("/owner-index");
                    break;
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            else{
                try {
                    response.sendRedirect("/customer-login-error-page");
                    break;
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }

    }
    @GetMapping("/customer-login-error-page")
    public String loginError() {
        return "login-error-page.html";
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
