package org.jdc.securitymaster.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jdc.securitymaster.annotation.SuperAdmin;
import org.jdc.securitymaster.dao.CustomerDao;
import org.jdc.securitymaster.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerDao customerDao;

    @RolesAllowed({"CUSTOMERS_PAG_VIEW", "CUSTOMERS_READ", "SUPER_ADMIN"})
    @GetMapping("/list-customer")
    public ModelAndView getCustomers() {
        return new ModelAndView("customers", "customers", customerDao.findAll());
    }

    @SuperAdmin
    @GetMapping("/customer-form")
    public ModelAndView getCustomerForm() {
        return new ModelAndView("customerForm", "customer", new Customer());
    }

    @SuperAdmin
    @PostMapping("/save-customer")
    public String saveCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customerForm";
        }

        customerDao.save(customer);
        return "redirect:/list-customer";
    }

    @SuperAdmin
    @GetMapping("/delete-customer")
    public String deleteCustomer(@RequestParam long id) {
        customerDao.deleteById(id);
        return "redirect:/list-customer";
    }

}
