package org.jdc.securitymaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalErrorController implements ErrorController {

    @GetMapping("/error")
    public String errorPage(HttpServletRequest request, Model model) {
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");

        String msg = switch(statusCode) {
            case 403 -> "Forbidden Resources";
            case 404 -> "Not Found Error";
            default -> {
                yield "Unknown Error";
            }
        };

        model.addAttribute("msg", msg);
        model.addAttribute("statusCode", statusCode);
        return "errorPage";
    }
}
