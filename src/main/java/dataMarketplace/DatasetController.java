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
        datasets.put(0,new Dataset(0,"name1",0,"description0"));
        datasets.put(1,new Dataset(1,"name2",1,"description1"));
        datasets.put(2,new Dataset(2,"name3",2,"description2"));
        datasets.put(3,new Dataset(3,"name4",3,"description3"));
        datasets.put(4,new Dataset(4,"name5",4,"description4"));
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
