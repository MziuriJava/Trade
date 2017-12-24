package ge.mziuri.trade.model.item;

import ge.mziuri.trade.model.owner.Owner;
import java.io.Serializable;



public class Item implements Serializable{

    private int id;

    private String name;

    private double quality;
    
    private Owner owner;

    public int getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
