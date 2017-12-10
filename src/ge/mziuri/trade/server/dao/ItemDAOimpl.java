package ge.mziuri.trade.server.dao;

import ge.mziuri.trade.model.exception.TSPException;
import ge.mziuri.trade.model.item.Item;
import ge.mziuri.trade.model.owner.Owner;
import ge.mziuri.trade.server.utility.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class ItemDAOimpl implements ItemDAO{

    @Override
    public void addItem(Item item) throws TSPException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DatabaseConnector.getConnection();
            pstmt = con.prepareStatement("INSERT INTO footballer (firstname, lastname, goals, fk_team) VALUES (?,?,?,?)");
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setDouble(3, item.getQuality());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            throw new TSPException("Can't add footballer", ex);
        } finally {
            try {
                pstmt.close();
                con.close();
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void deleteItem(Item item) throws TSPException {
        try {
            Connection con = DatabaseConnector.getConnection();
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM footballer WHERE id=?");
            pstmt.setInt(1, item.getId());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            throw new TSPException("Couldn't delete footballer try again later ", ex);
        }
    }

    @Override
    public List<Item> getOwnersItems(Owner owner) throws TSPException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendTrade(Item item1, Item item2) throws TSPException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acceptTrade(Item item1, Item item2) throws TSPException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }