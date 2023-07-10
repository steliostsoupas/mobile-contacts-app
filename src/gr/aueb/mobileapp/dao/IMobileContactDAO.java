package gr.aueb.mobileapp.dao;

import gr.aueb.mobileapp.model.MobileContact;

import java.util.List;

/**
 * The IMobileContactDAO interface defines operations for accessing and manipulating MobileContact objects in a data store.
 */
public interface IMobileContactDAO {

    MobileContact insert(MobileContact mobileContact);

    MobileContact update(long id, MobileContact mobileContact);

    void delete(String phoneNumber);

    MobileContact get(long id);

    List<MobileContact> getAll();

    MobileContact get(String phoneNumber);

    void delete(long id);

    boolean phoneNumberExists(String phoneNumber);

    boolean userIdExists(long id);
}
