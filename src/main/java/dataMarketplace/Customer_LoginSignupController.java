package dataMarketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class Customer_LoginSignupController extends HttpServlet {
    @Autowired CustomerRepository customerRepository;
    HashMap<Integer, Customer> customerList = new HashMap<>();

    private Customer customer(String password, String email){
        Customer customer = new Customer();
        customer.setPassword(password);
        customer.setEmail(email);
        return customer;
    }
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
    public void loginCustomer(Customer data, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {
        if(admin_exist==0){
        setAdminCustomer(customerList);
        }
     /*   for (int i = 0; i < count; i++) {
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

        }*/
        if(Validate.checkCustomer(data.getCustomerId(), data.getPassword())){
            response.sendRedirect("/browsedatasets");
        }else{
            response.sendRedirect("/customer-login-error-page");
        }

    }
    @GetMapping("/customer-login-error-page")
    public String loginError() {
        return "login-error-page.html";
    }

    @GetMapping("/customer-signup-error-page")
    public String signupError() { return "signup-error-page.html"; }

    @GetMapping("/signup-customer")
    public String signupCustomer() {
        return "signup-customer.html";
    }
    @PostMapping("/signup-customer")
    public void addCustomer(Customer data, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        Customer c = new Customer();
        if(Validate.checkCustomerID(data.getCustomerId())){
            response.sendRedirect("/customer-signup-error-page");
        }else {
            c.setCustomerId(data.getCustomerId());
            c.setPassword(data.getPassword());
            c.setEmail(data.getEmail());
            customerRepository.save(c);
            //  customerList.put(count, data);
            count++;
            response.sendRedirect("/browsedatasets");
        }
    }
}
