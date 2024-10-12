package org.jdc.securitymaster.controller;

import lombok.RequiredArgsConstructor;
import org.jdc.securitymaster.security.ds.SignupModel;
import org.jdc.securitymaster.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup-form")
    public String signupForm(Model model) {
        model.addAttribute("signup", new SignupModel());
        return "signupForm";
    }

    @PostMapping("/save-signup")
    public String processSignup(SignupModel signup, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signupForm";
        }
        userService.signup(signup);
        return "redirect:/login";
    }
}
