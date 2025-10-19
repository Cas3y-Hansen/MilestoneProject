package com.milestone.controller;

import com.milestone.model.RegisterModel;
import com.milestone.service.RegistrationService;

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
 * Controller for handling user registration functionality
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private final RegistrationService registrationService;
    public RegisterController(RegistrationService rs){ this.registrationService = rs; }

    /**
     * Displays the registration form page
     * @param model the model to hold view data
     * @return the register view template
     */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("registerModel", new RegisterModel());
        return "register";
    }

    /**
     * Processes the registration form submission
     * @param registerModel the registration data from the form
     * @param bindingResult validation results
     * @param model the model to hold view data
     * @return redirect to allbooks on success, or register view on error
     */
    @PostMapping("/doRegister")
    public String doRegister(@Valid @ModelAttribute("registerModel") RegisterModel registerModel,
                             BindingResult bindingResult,
                             Model model, RedirectAttributes ra) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Register");
            return "register";
        }
        if (!registrationService.register(registerModel)) {
            bindingResult.rejectValue("confirmPassword","mismatch","Passwords do not match");
            return "register";
        }
        ra.addFlashAttribute("message","Account created. Please log in.");

        // Redirect to All Books after registration
        return "redirect:/login/";
    }
}
