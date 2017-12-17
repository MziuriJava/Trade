package ge.mziuri.trade.server.dao;

import ge.mziuri.trade.model.exception.TSPException;
import ge.mziuri.trade.model.item.Item;
import ge.mziuri.trade.model.owner.Owner;

import java.util.List;

public interface ItemDAO {

    void addItem(Item item) throws TSPException;

    void deleteItem(Item item) throws TSPException;

    List <Item> getOwnersItems(Owner owner) throws TSPException;

    void sendTrade(Item item1,Item item2) throws TSPException;

    void  acceptTrade(Item item1,Item item2) throws TSPException;

}
