package dataMarketplace;

import javax.persistence.Column;

public class Item {
    private int datasetid;
    private String name;
    private int price;
    private String description;
    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Item(int datasetid, String name, int price, String description, int number) {
        this.datasetid = datasetid;
        this.name = name;
        this.price = price;
        this.description = description;
        this.number = number;
    }
}
