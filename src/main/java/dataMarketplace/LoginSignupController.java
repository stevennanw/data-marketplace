package dataMarketplace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSignupController {

    @GetMapping("/login-owner")
    public String loginOwner() {
        return "login-owner.html";
    }

    @GetMapping("/login-customer")
    public String loginCustomer() {
        return "login-customer.html";
    }

    @GetMapping("/signup-owner")
    public String signupOwner() {
        return "signup-owner.html";
    }

    @GetMapping("/signup-customer")
    public String signupCustomer() {
        return "signup-customer.html";
    }
}
