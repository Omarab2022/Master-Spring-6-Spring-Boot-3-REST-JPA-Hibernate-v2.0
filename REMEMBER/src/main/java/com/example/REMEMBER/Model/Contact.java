package com.example.REMEMBER.Model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {

 /*  This class represents a contact message with fields for name, mobile number, email, subject, and message.
    It includes validation annotations to ensure that the fields are not blank, have appropriate sizes,
    and that the email is in a valid format. The mobile number must contain only digits and be within a specified length.
    The class uses Lombok's @Data annotation to automatically generate getters, setters, and other utility methods.
    The validation annotations are from the Jakarta Bean Validation API, which is commonly used in Spring applications
    to validate user input in web forms.

  */


    @NotBlank(message = "Name is required")
    @Size(min=4 , max = 30 , message = "Name must be between 4 and 30 characters")
    public String name;

    @NotBlank(message = "Mobile number is required")
    @Size(min=10, max=15, message = "Mobile number must be between 10 and 15 digits")
    @Pattern(regexp = "^[0-9]+$", message = "Mobile number must contain only digits")
    public String mobileNum;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    public String email;

    @NotBlank(message = "Subject is required")
    @Size(min=4, max=50, message = "Subject must be between 4 and 50 characters")
    public String subject;

    @NotBlank(message = "Message is required")
    @Size(min=10, max=500, message = "Message must be between 10 and 500 characters")
    public String message;

}
