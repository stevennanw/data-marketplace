package dataMarketplace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class ShoppingCartController extends HttpServlet {
    HashMap<Dataset, Integer> shoppingCart = new HashMap<>();
        @PostMapping("/addcart")
        public void addlocation(Dataset dataset1, HttpServletResponse response) {
            if(!shoppingCart.containsKey(dataset1))
            {
                shoppingCart.put(dataset1,1);
            }
        }
}