package com.example.REMEMBER.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewControllerConfig implements WebMvcConfigurer {




    @Override
    public void addViewControllers(ViewControllerRegistry Register) {
        Register.addViewController("/home").setViewName("home");
        Register.addViewController("/").setViewName("home");
        Register.addViewController("/courses").setViewName("courses");
//        Register.addViewController("/contact").setViewName("contact");
        Register.addViewController("/about").setViewName("about");
        Register.addViewController("/holidays").setViewName("holidays");

    }


}
