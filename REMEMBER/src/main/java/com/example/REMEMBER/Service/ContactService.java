package com.example.REMEMBER.Service;


import com.example.REMEMBER.Model.Contact;
import com.example.REMEMBER.Repository.ContactRepo;
import com.example.REMEMBER.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {

    private final ContactRepo contactRepo ;



    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }


    public boolean saveMessage(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(Constants.OPEN);
        contact.setCreatedBy(Constants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());

        Contact savedContact = contactRepo.save(contact);

        if (null != savedContact && savedContact.getContactId() > 0) {
            isSaved = true;
        }

        return isSaved;
    }


    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepo.findByStatus(Constants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy) {
        boolean isUpdated = false;

        Optional<Contact> contactOptional = contactRepo.findById(contactId);

        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            contact.setStatus(Constants.CLOSE);
            contact.setUpdatedBy(updatedBy);
            contact.setUpdatedAt(LocalDateTime.now());
            contactRepo.save(contact); // persist changes
            isUpdated = true;
        }

        return isUpdated;
    }


}
