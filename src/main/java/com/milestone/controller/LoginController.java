package com.milestone.controller;

import com.milestone.model.LoginModel;
import com.milestone.service.AuthService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for handling user login functionality
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;
    public LoginController(AuthService authService){ this.authService = authService; }

    /**
     * Displays the login form page
     * @param model the model to hold view data
     * @return the login view template
     */

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute("loginModel", new LoginModel());
        return "login"; 
    }

    /**
     * Processes the login form submission
     * @param loginModel the login data from the form
     * @param bindingResult validation results
     * @param model the model to hold view data
     * @return redirect to allbooks on success, or login view on error
     */
    @PostMapping("/doLogin")
    public String doLogin(@Valid @ModelAttribute("loginModel") LoginModel loginModel,
                          BindingResult bindingResult,
                          Model model, RedirectAttributes ra) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login");
            return "login";
        }

        boolean ok = authService.authenticate(loginModel.getUsername(), loginModel.getPassword());
        if (!ok) {
            bindingResult.reject("auth.failed", "Invalid username or password");
            return "login";
        }

        return "redirect:/allbooks";
    }
}
