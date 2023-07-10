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

import java.util.List;

public class MobileContactsApp {

    // Wiring
    private static final IMobileContactDAO dao = new MobileContactDAOImpl();
    private static final IMobileContactService service = new MobileContactServiceImpl(dao);

    public static void main(String[] args) {
        try {
            // DTO
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO(1L, "Alice", "W.");
            MobileContactDTO mobileContactDTO = new MobileContactDTO(1L, userDetailsDTO, "123456");
            UserDetailsDTO updatedUserDetailsDTO = new UserDetailsDTO(1L, "Alice", "Wonder");
            MobileContactDTO updatedMobileContactDTO = new MobileContactDTO(1L, updatedUserDetailsDTO, "123456");

            // Service
            service.insertMobileContact(mobileContactDTO);
            service.updateMobileContact(1L, updatedMobileContactDTO);

            // Return back
            List<MobileContact> contacts = service.getAllMobileContacts();
            for (MobileContact contact : contacts) {
                System.out.println(contact);
            }

        } catch (PhoneNumberAlreadyExistsException | UserIdAlreadyExistsException | MobileContactNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
