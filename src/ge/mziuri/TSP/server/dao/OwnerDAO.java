package ge.mziuri.TSP.server.dao;

import ge.mziuri.TSP.model.exception.TSPException;
import ge.mziuri.TSP.model.owner.Owner;

public interface OwnerDAO {

    void addOwner(Owner owner) throws TSPException;

    void deleteOwner(Owner owner) throws TSPException;

    void changePassword(Owner password) throws TSPException;


}
