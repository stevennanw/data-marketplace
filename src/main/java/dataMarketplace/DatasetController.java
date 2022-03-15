package dataMarketplace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class DatasetController extends HttpServlet {
    HashMap<Integer, Dataset> datasets = new HashMap<>();
    int initialize = 0;
    int count=0;
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
        model.addAttribute("dataset",datasets.get(id));
        return "owner-view.html";
    }
    @GetMapping("/owner-adddataset")
    public String addDataset() {
        return "owner-adddataset.html";
    }

    @PostMapping("/owner-adddataset")
    public void addDataset(@RequestParam(name = "name") String name, @RequestParam(name = "price") int price, @RequestParam(name = "description") String description, HttpServletResponse response) {
        count = datasets.size() -1;
        System.out.print(count);
        Dataset data = new Dataset(count, name, price, description, 0);
        datasets.put(count, data);
        count++;
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
}
