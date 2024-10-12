package org.jdc.securitymaster.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jdc.securitymaster.annotation.SuperAdmin;
import org.jdc.securitymaster.dao.DepartmentDao;
import org.jdc.securitymaster.entity.Department;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentDao departmentDao;

    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'DEPARTMENTS_PAG_VIEW', 'DEPARTMENTS_READ', 'DEPARTMENTS_CREATE')")
    @GetMapping("/list-department")
    public ModelAndView listDepartment() {
        return new ModelAndView("departments", "departments", departmentDao.findAll());
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'DEPARTMENTS_PAG_VIEW', 'DEPARTMENTS_READ', 'DEPARTMENTS_CREATE')")
    @GetMapping("/department-form")
    public ModelAndView departmentForm() {
        return new ModelAndView("departmentForm", "department", new Department());
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'DEPARTMENTS_PAG_VIEW', 'DEPARTMENTS_READ', 'DEPARTMENTS_CREATE')")
    @PostMapping("/save-department")
    public ModelAndView saveDepartment(@Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("departmentForm", "department", department);
        }
        departmentDao.save(department);
        return new ModelAndView("redirect:/list-department");
    }

    @SuperAdmin
    @GetMapping("/delete-department/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        departmentDao.deleteById(id);
        return "redirect:/list-department";
    }
}
