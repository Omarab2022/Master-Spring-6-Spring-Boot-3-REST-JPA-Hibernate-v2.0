package com.example.REMEMBER.Config;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {




    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex){


        ModelAndView errorpage = new ModelAndView();
        errorpage.setViewName("error");;
        errorpage.addObject("errormsg" , ex.getMessage());

        return errorpage;

    }
}
