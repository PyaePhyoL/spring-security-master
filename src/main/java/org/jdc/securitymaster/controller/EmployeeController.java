package org.jdc.securitymaster.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jdc.securitymaster.dao.EmployeeDao;
import org.jdc.securitymaster.entity.Employee;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeDao employeeDao;

    @Secured({"ROLE_SUPER_ADMIN", "ROLE_EMPLOYEES_ADMIN"})
    @GetMapping("/list-employee")
    public String listAllEmployees(Model model) {
        model.addAttribute("employees", employeeDao.findAll());
        return "employees";
    }

    @Secured({"ROLE_SUPER_ADMIN", "ROLE_EMPLOYEES_ADMIN"})
    @GetMapping("/employee-form")
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    @Secured({"ROLE_SUPER_ADMIN", "ROLE_EMPLOYEES_ADMIN"})
    @PostMapping("/save-employee")
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employeeForm";
        }
        employeeDao.save(employee);
        return "redirect:/list-employee";
    }

    @Secured({"ROLE_SUPER_ADMIN", "ROLE_EMPLOYEES_ADMIN"})
    @GetMapping("/delete-employee")
    public String deleteEmployeeById(@RequestParam long id) {
        employeeDao.deleteById(id);
        return "redirect:/list-employee";
    }
}
