package com.example.REMEMBER.Repository;


import com.example.REMEMBER.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/*    This class is a repository for managing Contact entities.
    It is annotated with @Repository to indicate that it is a Spring Data repository.
    You can add methods here to interact with the database, such as saving, updating, deleting, and querying Contact entities.
*/

@Repository
public class ContactRepo {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public ContactRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveContactMesg(Contact contact){
        String sql = "INSERT INTO CONTACT_MSG" +
                "(NAME, MOBILE_NUM, EMAIL, SUBJECT, MESSAGE, STATUS , CREATED_AT , CREATED_BY ) " +
                "VALUES (?, ?, ?, ?, ?, ?,?,? )";

        return jdbcTemplate.update(sql,
                contact.getName(),
                contact.getMobileNum(),
                contact.getEmail(),
                contact.getSubject(),
                contact.getMessage(),
                contact.getStatus(),
                contact.getCreatedAt(),
                contact.getCreatedBy()
        );
    }
}
