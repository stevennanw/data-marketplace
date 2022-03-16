package dataMarketplace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
    @GetMapping("/checkout")
    public String toCheckOut() {
        return "checkout.html";
    }

}
