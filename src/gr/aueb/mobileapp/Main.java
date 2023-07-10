package gr.aueb.mobileapp;

import gr.aueb.mobileapp.dao.IMobileContactDAO;
import gr.aueb.mobileapp.dao.MobileContactDAOImpl;
import gr.aueb.mobileapp.dto.MobileContactDTO;
import gr.aueb.mobileapp.dto.UserDetailsDTO;
import gr.aueb.mobileapp.model.MobileContact;
import gr.aueb.mobileapp.service.IMobileContactService;
import gr.aueb.mobileapp.service.MobileContactServiceImpl;
import gr.aueb.mobileapp.service.exceptions.MobileContactNotFoundException;
import gr.aueb.mobileapp.service.exceptions.PhoneNumberAlreadyExistsException;
import gr.aueb.mobileapp.service.exceptions.UserIdAlreadyExistsException;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the DAO and Service
        IMobileContactDAO contactDAO = new MobileContactDAOImpl();
        IMobileContactService contactService = new MobileContactServiceImpl(contactDAO);

        // Create a new user details
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(1);
        userDetailsDTO.setFirstname("John");
        userDetailsDTO.setLastname("Doe");

        // Create a new mobile contact
        MobileContactDTO contactDTO = new MobileContactDTO();
        contactDTO.setId(1);
        contactDTO.setUserDetails(userDetailsDTO);
        contactDTO.setPhoneNumber("1234567890");

        try {
            // Insert the mobile contact
            MobileContact createdContact = contactService.insertMobileContact(contactDTO);
            System.out.println("Mobile contact created: " + createdContact);

            // Update the mobile contact
            MobileContact updatedContact = contactService.updateMobileContact(1, contactDTO);
            System.out.println("Mobile contact updated: " + updatedContact);
        } catch (MobileContactNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (PhoneNumberAlreadyExistsException | UserIdAlreadyExistsException e) {
            System.out.println("Error creating/updating mobile contact: " + e.getMessage());
        }
    }
}
