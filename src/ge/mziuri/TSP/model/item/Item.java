package ge.mziuri.TSP.model.item;

import java.io.Serializable;



public class Item implements Serializable{

    private int id;

    private String name;

    private double quality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return  "Item{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", quality=" + quality +
                '}';
    }
}
