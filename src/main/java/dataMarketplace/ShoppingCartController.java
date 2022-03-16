package dataMarketplace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class ShoppingCartController extends HttpServlet {
    HashMap<Dataset, Integer> shoppingCart = new HashMap<>();
    @PostMapping("/addcart")
    public void addcart(Dataset dataset1, HttpServletResponse response) {
        System.out.println("Hello");
        if(!shoppingCart.containsKey(dataset1))
        {
            shoppingCart.put(dataset1,1);
        }else{
            shoppingCart.put(dataset1,shoppingCart.get(dataset1)+1);
        }
    }

    @GetMapping("/payment")
    public String browseCart(Model model) {
        //setDatasets(shoppingCart);
        System.out.println("Hi");
        for (int i =0; i<shoppingCart.size();i++){
            System.out.println(shoppingCart.values());
        }
        model.addAttribute("datasets", shoppingCart.values());
        return "payment.html";
    }
}