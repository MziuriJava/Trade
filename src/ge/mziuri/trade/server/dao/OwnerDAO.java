package ge.mziuri.trade.server.dao;

import ge.mziuri.trade.model.exception.TSPException;
import ge.mziuri.trade.model.owner.Owner;

public interface OwnerDAO {

    void addOwner(Owner owner) throws TSPException;

    void deleteOwner(Owner owner) throws TSPException;

    void changePassword(Owner password) throws TSPException;


}
