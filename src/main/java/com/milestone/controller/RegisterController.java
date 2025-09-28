package com.milestone.controller;

import com.milestone.model.RegisterModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("registerModel", new RegisterModel());
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid @ModelAttribute("registerModel") RegisterModel registerModel,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Register");
            return "register";
        }

        // Redirect to All Books after registration
        return "redirect:/allbooks";
    }
}
