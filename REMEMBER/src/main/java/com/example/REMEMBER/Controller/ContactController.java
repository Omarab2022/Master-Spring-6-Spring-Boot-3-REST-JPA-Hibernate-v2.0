package com.example.REMEMBER.Controller;


import com.example.REMEMBER.Model.Contact;
import com.example.REMEMBER.Service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
public class ContactController {


//    @RequestMapping(value = "/saveMsg" , method = POST)
//    public ModelAndView saveMessage(@RequestParam String name , @RequestParam String mobileNum,
//                                    @RequestParam String email ,  @RequestParam String subject ,
//                                    @RequestParam String message
//                                   ) {
//
//        log.info("Received message from: " + name);
//        log.info("Mobile Number: " + mobileNum);
//        log.info("Email: " + email);
//        log.info("Subject: " + subject);
//        log.info("Message: " + message);
//        return new ModelAndView( "redirect:/contact" )
//                .addObject("successMessage", "Message sent successfully!");
//    }


    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping("/contact")
    public String displaycontact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }


    /**
     * This method handles the submission of the contact form.
     * It validates the input using the @Valid annotation,
     * and if the input is valid, it saves the message using the contactService.
     * If the message is saved successfully, it redirects to the contact page.
     * * @param contact The contact message submitted by the user.
     * * @return A ModelAndView object that redirects to the contact page.
     * This method uses the POST HTTP method to handle form submissions.
     * * @Valid annotation is used to validate the Contact object based on the constraints defined in the Contact class.
     * * The @ModelAttribute annotation binds the form data to the Contact object.
     * * The method returns a ModelAndView object that redirects to the contact page after saving the message.
     */

    @RequestMapping(value = "/saveMsg", method = POST)
    public String saveMsg(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {

        if (errors.hasErrors()) {
            log.info("Contact form has errors: " + errors.toString());
            return "contact.html";
        }
        contactService.saveMessage(contact);
        return "redirect:/contact";
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model) {

        List<Contact> contactList = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs", contactList);

        return modelAndView;

    }


    @RequestMapping(value = "/closeMsg", method = GET )
    public String CloseMsg(@RequestParam int id , Authentication authentication){
        contactService.updateMsgStatus(id , authentication.getName());
        return "redirect:/displayMessages";

    }


}
