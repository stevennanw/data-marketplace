package dataMarketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
//import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class DatasetController extends HttpServlet {
    @Autowired OrderRepository orderRepository;
    HashMap<Integer, Dataset> datasets = new HashMap<>();
    int initialize = 0;
    int count=0;
    int datasetID=0;
    public void setDatasets(HashMap<Integer, Dataset> datasets) {
        this.datasets = datasets;
        datasets.put(0,new Dataset(0,"name0",0,"description0",0));
        datasets.put(1,new Dataset(1,"name1",1,"description1",0));
        datasets.put(2,new Dataset(2,"name2",2,"description2",0));
        datasets.put(3,new Dataset(3,"name3",3,"description3",0));
        datasets.put(4,new Dataset(4,"name4",4,"description4",0));
        datasets.put(5,new Dataset(5,"name5",0,"description5",0));
        datasets.put(6,new Dataset(6,"name6",1,"description6",0));
        datasets.put(7,new Dataset(7,"name7",2,"description7",0));
        datasets.put(8,new Dataset(8,"name8",3,"description8",0));
        datasets.put(9,new Dataset(9,"name9",4,"description9",0));
        initialize = 1;
    }

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/browsedatasets")
    public String browseDataset(Model model) {
        if(initialize==0) {
            setDatasets(datasets);
        }
        model.addAttribute("datasets", datasets.values());
        return "browsedatasets.html";
    }

    @GetMapping("/view/{id}")
    public String viewLocations(@PathVariable int id, Model model) {
        model.addAttribute("dataset",datasets.get(id));
        return "view.html";
    }

    @GetMapping("/owner-index")
    public String ownerDataset(Model model) {
        if(initialize==0) {
            setDatasets(datasets);
        }
        model.addAttribute("datasets", datasets.values());
        return "owner-index.html";
    }
    @GetMapping("/owner-index/{id}")
    public String hideDataset(@PathVariable int id, Model model) {
        datasets.remove(id);
        model.addAttribute("datasets", datasets.values());
        return "owner-index.html";
    }
    @GetMapping("/owner-view/{id}")
    public String ownerView(@PathVariable int id, Model model) {
        datasetID=id;
        model.addAttribute("dataset",datasets.get(id));
        return "owner-view.html";
    }
    @GetMapping("/owner-adddataset")
    public String addDataset() {
        return "owner-adddataset.html";
    }

    @PostMapping("/owner-adddataset")
    public void addDataset(@RequestParam(name = "name") String name, @RequestParam(name = "price") int price, @RequestParam(name = "description") String description, HttpServletResponse response) {
        count = datasets.size();
        System.out.print(count);
        Dataset data = new Dataset(count, name, price, description, 0);
        datasets.put(count, data);
        try {
            response.sendRedirect("/owner-index");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @GetMapping("/owner-edit")
    public String editDataset() {
        return "owner-edit.html";
    }
    @PostMapping("/owner-edit")
    public void editDataset(@RequestParam(name = "name") String name, @RequestParam(name = "price") int price, @RequestParam(name = "description") String description, HttpServletResponse response) {

        Dataset data = new Dataset(datasetID, name, price, description, 0);
        datasets.replace(datasetID, data);
        try {
            response.sendRedirect("/owner-index");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @GetMapping("/contactus")
    public String contactus() {
        return "contactus.html";
    }

    @GetMapping("/promotion")
    public String promote() {
        return "promotion.html";
    }


    HashMap<Dataset, Integer> shoppingCart = new HashMap<>();
    int orderId = 10000 + (int) (Math.random() * 10000);
    @GetMapping("/addcart/{id}")
    public String addcart(@PathVariable int id, Model model, HttpServletResponse response) {
   //     System.out.println("Hello");
        Dataset dataset = datasets.get(id);
        if(!shoppingCart.containsKey(dataset))
        {
            shoppingCart.put(dataset,1);
        }else{
            shoppingCart.put(dataset,shoppingCart.get(dataset)+1);
        }
    //    System.out.println("jo");
    //    System.out.println(shoppingCart.size());
        model.addAttribute("dataset",datasets.get(id));
        return "addcart.html";
    }
    @GetMapping("/addnumber/{id}")
    public String addnumber(@PathVariable int id, Model model) {
        Dataset dataset = datasets.get(id);
        shoppingCart.replace(dataset, shoppingCart.get(dataset)+1);
        model.addAttribute("datasets", shoppingCart.values());
        return "editcart.html";
    }
    @GetMapping("/subnumber/{id}")
    public String subnumber(@PathVariable int id, Model model) {
        Dataset dataset = datasets.get(id);
        if(shoppingCart.get(dataset)==1){
            shoppingCart.remove(dataset);
        }else {
            shoppingCart.replace(dataset, shoppingCart.get(dataset) - 1);
        }
        model.addAttribute("datasets", shoppingCart.values());
        return "editcart.html";
    }
    @GetMapping("/removecart/{id}")
    public String removecart(@PathVariable int id, Model model) {
        Dataset dataset = datasets.get(id);
        shoppingCart.remove(dataset);
        model.addAttribute("datasets", shoppingCart.values());
        return "removecart.html";
    }
    // TODO
    @GetMapping("/payment")
    public String browseCart(Model model) throws SQLException, ClassNotFoundException {
        //setDatasets(shoppingCart);
        HashMap<Integer, Item> cart = new HashMap<>();
        int i = 0;
        int totalmoney = 0;
        for (Dataset d : shoppingCart.keySet()) {
         //   System.out.println("getdatasetID"+d.getDatasetid());
            cart.put(i,new Item(d.getDatasetid(),d.getName(),d.getPrice(),d.getDescription(),0));
            i++;
        }
        i = 0;
        for (int num : shoppingCart.values()) {
         //   System.out.println("num"+num);
            cart.put(i,new Item(cart.get(i).getDatasetid(),cart.get(i).getName(),cart.get(i).getPrice(),cart.get(i).getDescription(),num));
            totalmoney = totalmoney + cart.get(i).getPrice() * num;
            i++;
        }
        while(Validate.checkOrderID(orderId)){
            orderId = 10000 + (int) (Math.random() * 10000);
        }
     //   System.out.println("size:"+cart.size());
        //model.addAttribute("datasets", shoppingCart.values());
        model.addAttribute("cart", cart.values());
        model.addAttribute("totalmoney", totalmoney);
        return "payment.html";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        StringBuilder description = new StringBuilder();
        for (Dataset d: shoppingCart.keySet()){
            description.append(shoppingCart.get(d)).append("*").append(d.getName()).append(" ").append(d.getPrice()*shoppingCart.get(d)).append("euro,");
        }
        description.deleteCharAt(description.length()-1);
        Order o = new Order();

        o.setOrderID(orderId);

        o.setCustomerID(Singleton.customer_login_id);
       // System.out.println(Singleton.getInstance());
        o.setDescription(description.toString());
        o.setState(true);
        if(Singleton.customer_login_id != 0)
            orderRepository.save(o);
        model.addAttribute("orderId",orderId);
        model.addAttribute("description",description);
        return "checkout.html";
    }

    @GetMapping("/c_order_history")
    public String Customer_Order_History(Model model) throws ClassNotFoundException, SQLException {
        SQLInformationMapper mapper = new SQLInformationMapper();
        Class.forName(mapper.getDriver());
        Connection conn = DriverManager.getConnection(mapper.getUrl(), mapper.getUsername(), mapper.getPass());
        Statement stmt = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement("select orderid,description from orders where customerid=?");
        ps.setInt(1, Singleton.customer_login_id);
        conn.close();
        return "customer_order_history.html";
    }

    @GetMapping("/o_order_control")
    public String Owner_Order_Control(Model model) throws ClassNotFoundException, SQLException {
        SQLInformationMapper mapper = new SQLInformationMapper();
        Class.forName(mapper.getDriver());
        Connection conn = DriverManager.getConnection(mapper.getUrl(), mapper.getUsername(), mapper.getPass());
        PreparedStatement ps = conn.prepareStatement("select * from orders");
        conn.close();
        return "owner_order_control.html";
    }

    @GetMapping("/o_change_status")
    public String Owner_Change_Order_Status(){
        //MySQL code typo:
        //UPDATE employees
        //SET
        //    email = 'mary.patterson@classicmodelcars.com'
        //WHERE
        //    employeeNumber = 1056;
        return "changestatus.html";
    }
}
