package ge.mziuri.trade.server.dao;

import ge.mziuri.trade.model.exception.TSPException;
import ge.mziuri.trade.model.owner.Owner;
import ge.mziuri.trade.server.utility.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OwnerDAOImpl implements OwnerDAO{
    @Override
    public void addOwner(Owner owner) throws TSPException {
        try {
            Connection con = DatabaseConnector.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Owner (id, name, email, password) VALUES (?,?)");
            pstmt.setInt(1, owner.getId());
            pstmt.setString(2, owner.getName());
            pstmt.setString(3, owner.getEmail());
            pstmt.setString(4, owner.getPassword());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            throw new TSPException("Can't Add Owner", ex);
        }
        
    }

    @Override
    public void deleteOwner(Owner owner) throws TSPException {
        try {
            Connection con = DatabaseConnector.getConnection();
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM owner WHERE id=?");
            pstmt.setInt(1, owner.getId());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            throw new TSPException("Couldn't delete owner ", ex);
        }
    }

    @Override
    public void changePassword(Owner owner, String newPassword) throws TSPException {
        try {
            Connection con = DatabaseConnector.getConnection();
            PreparedStatement pstmt = con.prepareStatement("UPDATE owner SET password=? WHERE id=?");
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, owner.getId());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            throw new TSPException("Couldn't Change Password ", ex);
        }
    }
}
