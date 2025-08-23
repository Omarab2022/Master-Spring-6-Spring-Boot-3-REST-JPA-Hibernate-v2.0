package com.example.REMEMBER.Service;


import com.example.REMEMBER.Model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {


    public boolean saveMessage(Contact contact) {
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }

}
