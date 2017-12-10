package ge.mziuri.trade.server.dao;

import ge.mziuri.trade.model.exception.TSPException;
import ge.mziuri.trade.model.item.Item;
import ge.mziuri.trade.model.owner.Owner;

import java.util.List;

public class ItemDAOimpl implements ItemDAO{

    @Override
    public void addItem(Item item) throws TSPException {

    }

    @Override
    public void deleteItem(Item item) throws TSPException {

    }

    @Override
    public void checkQuality(Item quality) throws TSPException {

    }

    @Override
    public List<Item> getOwnersItems(Owner owner) throws TSPException {
        return null;
    }

    @Override
    public void sendTrade(Item item1, Item item2) throws TSPException {

    }

    @Override
    public void acceptTrade(Item item1, Item item2) throws TSPException {

    }
}
