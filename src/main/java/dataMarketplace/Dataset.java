package dataMarketplace;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "datasets")
public class Dataset implements Serializable {
    @Id
    @GeneratedValue
    private int datasetid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int ownerid;

    public int getDatasetid() {
        return datasetid;
    }

    public void setDatasetid(int datasetid) {
        this.datasetid = datasetid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public Dataset(int datasetid, String name, int price, String description, int ownerid) {
        this.datasetid = datasetid;
        this.name = name;
        this.price = price;
        this.description = description;
        this.ownerid = ownerid;
    }


}
