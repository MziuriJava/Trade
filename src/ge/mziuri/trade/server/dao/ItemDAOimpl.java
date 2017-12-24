package ge.mziuri.trade.server.dao;

import ge.mziuri.trade.model.exception.TSPException;
import ge.mziuri.trade.model.item.Item;
import ge.mziuri.trade.model.owner.Owner;
import ge.mziuri.trade.server.utility.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class ItemDAOimpl implements ItemDAO {

    @Override
    public void addItem(Item item) throws TSPException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DatabaseConnector.getConnection();
            pstmt = con.prepareStatement("INSERT INTO item (id, name, quality, fk_owner) VALUES (?,?,?,?)");
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setDouble(3, item.getQuality());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            throw new TSPException("Can't add item", ex);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ignored) {}
        }
    }

    @Override
    public void deleteItem(Item item) throws TSPException {
        try {
            Connection con = DatabaseConnector.getConnection();
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM item WHERE id=?");
            pstmt.setInt(1, item.getId());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            throw new TSPException("Couldn't delete item try again later ", ex);
        }
    }

    @Override
    public List<Item> getOwnersItems(Owner owner) throws TSPException {
        try {
            Connection con = DatabaseConnector.getConnection();
            PreparedStatement pstms = con.prepareStatement("SELECT * FROM item WHERE fk_owner = ?");
            pstms.setInt(1, owner.getId());
            ResultSet rs = pstms.executeQuery();
            List<Item> items = new ArrayList<>();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name1"));
                item.setQuality(rs.getInt("3/5"));
                item.setOwner(owner);
                items.add(item);
            }
            pstms.close();
            con.close();
            return items;
        } catch (Exception ex) {
            throw new TSPException("Can't get item by owner", ex);
        }
    }

    @Override
    public void sendTrade(Item item1, Item item2) throws TSPException {
        try {
            Connection con = DatabaseConnector.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO OFFER (SENDER_ITEM_ID, RECEIVER_ITEM_ID) VALUES (?, ?)");
            pstmt.setInt(1, item1.getId());
            pstmt.setInt(2, item2.getId());
            
        } catch (Exception ex) {
            throw new TSPException("Can't Send The Trade Offer", ex);
        }
    }

    @Override
    public void acceptTrade(Item item1, Item item2) throws TSPException {
        try {

        } catch (Exception ex) {
            throw new TSPException("Can't Accept The Trade Offer", ex);
        }
    }
}
