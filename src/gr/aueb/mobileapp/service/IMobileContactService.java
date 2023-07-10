package gr.aueb.mobileapp.service;

import gr.aueb.mobileapp.dto.MobileContactDTO;
import gr.aueb.mobileapp.model.MobileContact;
import gr.aueb.mobileapp.service.exceptions.MobileContactNotFoundException;
import gr.aueb.mobileapp.service.exceptions.PhoneNumberAlreadyExistsException;
import gr.aueb.mobileapp.service.exceptions.UserIdAlreadyExistsException;

import java.util.List;

public interface IMobileContactService {
    MobileContact insertMobileContact(MobileContactDTO contactDTO)
            throws PhoneNumberAlreadyExistsException, UserIdAlreadyExistsException;

    MobileContact updateMobileContact(long id, MobileContactDTO contactDTO)
        throws MobileContactNotFoundException, PhoneNumberAlreadyExistsException, UserIdAlreadyExistsException;

    void deleteMobileContact(String phoneNumber) throws MobileContactNotFoundException;

    void deleteMobileContact(long id) throws MobileContactNotFoundException;

    MobileContact getMobileContact(String phoneNumber) throws MobileContactNotFoundException;

    MobileContact getMobileContact(long id) throws MobileContactNotFoundException;

    List<MobileContact> getAllMobileContacts();
}
