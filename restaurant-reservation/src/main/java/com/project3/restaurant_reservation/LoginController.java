package com.project3.restaurant_reservation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping("/employeeLogin")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<Login> user = loginRepository.findByUsernameAndPassword(username, password);

        if (user.isPresent()) {
            return "redirect:/employeeUI"; // Redirect to employeeUI if login is successful
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "employeeLogin"; // Return to login page with an error message
        }
    }
}
