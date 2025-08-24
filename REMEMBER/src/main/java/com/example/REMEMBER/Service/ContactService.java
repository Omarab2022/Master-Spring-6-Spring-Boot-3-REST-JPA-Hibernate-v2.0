package com.example.REMEMBER.Service;


import com.example.REMEMBER.Model.Contact;
import com.example.REMEMBER.Repository.ContactRepo;
import com.example.REMEMBER.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

        int result = contactRepo.saveContactMesg(contact);

        if (result > 0) {
            isSaved = true;
        }

        return isSaved;
    }


    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepo.findMsgsWithStatus(Constants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId , String updatedBy){

        boolean isUpdated = false;
       int result = contactRepo.updateMsgStatus(contactId, Constants.CLOSE, updatedBy);

       if (result > 0){
           isUpdated = true;
       }
       return isUpdated ;
    }

}
