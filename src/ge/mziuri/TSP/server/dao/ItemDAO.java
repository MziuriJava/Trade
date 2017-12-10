package ge.mziuri.TSP.server.dao;

import ge.mziuri.TSP.model.exception.TSPException;
import ge.mziuri.TSP.model.item.Item;
import ge.mziuri.TSP.model.owner.Owner;

import java.util.List;

public interface ItemDAO {

    void addItem(Item item) throws TSPException;

    void deleteItem(Item item) throws TSPException;

    void checkQuality(Item quality) throws TSPException;

    List <Item> getOwnersItems(Owner owner) throws TSPException;

    void sendTrade(Item item1,Item item2) throws TSPException;

    void  acceptTrade(Item item1,Item item2) throws TSPException;

}
