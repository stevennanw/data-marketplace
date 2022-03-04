package dataMarketplace;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;

public class DatasetController extends HttpServlet {
    HashMap<Integer, Dataset> dataset = new HashMap<>();

    public void setDataset(HashMap<Integer, Dataset> dataset) {
        this.dataset = dataset;
        dataset.put(0,new Dataset(0,"name1",0,"description0"));
        dataset.put(1,new Dataset(1,"name2",1,"description1"));
        dataset.put(2,new Dataset(2,"name3",2,"description2"));
        dataset.put(3,new Dataset(3,"name4",3,"description3"));
        dataset.put(4,new Dataset(4,"name5",4,"description4"));
    }
}
