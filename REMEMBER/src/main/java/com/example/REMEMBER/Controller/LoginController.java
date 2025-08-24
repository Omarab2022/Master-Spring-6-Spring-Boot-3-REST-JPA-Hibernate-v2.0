package com.example.REMEMBER.Controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

    /**
     * This method handles the request to the login page.
     * It returns the name of the login view to be rendered.
     *
     * @return The name of the login view.
     */

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
                                   @RequestParam(value = "logout", required = false) String logout,
                                   Model model) {

        String errorMessage = null;

        if (error != null) {
            errorMessage = "Invalid username or password";
        }
        if (logout != null) {
            errorMessage = "You have been logged out successfully";
        }
        model.addAttribute("errorMessge", errorMessage);

        return "login"; // Spring will resolve login.html from templates/
    }


    @RequestMapping(value = "/logout" , method = RequestMethod.GET)
    public String logout(HttpServletRequest request , HttpServletResponse response ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        log.info("User logged out successfully");
        return "redirect:/login?logout=true"; // Redirect to login page with logout message
    }


}
