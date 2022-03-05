package dataMarketplace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;

@Controller
public class DatasetController extends HttpServlet {
    HashMap<Integer, Dataset> datasets = new HashMap<>();

    public void setDatasets(HashMap<Integer, Dataset> datasets) {
        this.datasets = datasets;
        datasets.put(0,new Dataset(0,"name0",0,"description0"));
        datasets.put(1,new Dataset(1,"name1",1,"description1"));
        datasets.put(2,new Dataset(2,"name2",2,"description2"));
        datasets.put(3,new Dataset(3,"name3",3,"description3"));
        datasets.put(4,new Dataset(4,"name4",4,"description4"));
        datasets.put(5,new Dataset(5,"name5",0,"description5"));
        datasets.put(6,new Dataset(6,"name6",1,"description6"));
        datasets.put(7,new Dataset(7,"name7",2,"description7"));
        datasets.put(8,new Dataset(8,"name8",3,"description8"));
        datasets.put(9,new Dataset(9,"name9",4,"description9"));
    }

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/browsedatasets")
    public String browseDataset(Model model) {
        setDatasets(datasets);
        model.addAttribute("datasets", datasets.values());
        return "browsedatasets.html";
    }

    @GetMapping("/view/{id}")
    public String viewLocations(@PathVariable int id, Model model) {
        model.addAttribute("dataset",datasets.get(id));
        return "view.html";
    }
}