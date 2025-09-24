package com.milestone.controller;

import com.milestone.model.LoginModel;
import com.milestone.model.OrderModel;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login") // Step 5 requirement
public class LoginController {

    // Step 6: Display method
    @GetMapping("/")  // Handles GET requests to /login/
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel()); // ✅ Add this for Thymeleaf binding
        return "login"; 
    }

    // Step 12 & 15: Handle POST and create orders
    @PostMapping("/doLogin")
    public String doLogin(@Valid @ModelAttribute("loginModel") LoginModel loginModel,
                          BindingResult bindingResult,
                          Model model) {

        if (bindingResult.hasErrors()) {
            // Validation errors → go back to login view
            model.addAttribute("title", "Login Form");
            return "login";  // ✅ Thymeleaf will have loginModel to bind
        }

        // Create sample orders
        List<OrderModel> orders = new ArrayList<>();
        orders.add(new OrderModel(0L, "0000000001", "Product 1", 1.00f, 1));
        orders.add(new OrderModel(1L, "0000000002", "Product 2", 2.00f, 2));
        orders.add(new OrderModel(2L, "0000000003", "Product 3", 3.00f, 3));
        orders.add(new OrderModel(3L, "0000000004", "Product 4", 4.00f, 4));
        orders.add(new OrderModel(4L, "0000000005", "Product 5", 5.00f, 5));

        // Set attributes for the Orders view
        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);

        return "orders";  // Go to orders.html
    }
}