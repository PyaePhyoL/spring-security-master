package org.jdc.securitymaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name cannot be blanked")
    @Pattern(regexp = "[A-Za-z]*", message = "First name cannot contain illegal characters")
    private String firstName;
    @NotBlank(message = "Last name cannot be blanked")
    @Pattern(regexp = "[A-Za-z]*", message = "Last name cannot contain illegal characters")
    private String lastName;
    @NotBlank(message = "Phone Number cannot be blanked")
    @Pattern(regexp = "[0-9 \\-+]*", message = "Phone number cannot contain illegal characters")
    private String phoneNumber;
    @NotBlank(message = "Address cannot be blanked")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address cannot contain illegal characters")
    private String address;
    @NotBlank(message = "Cubicle No cannot be blanked")
    @Pattern(regexp = "[A-Za-z0-9\\-]*", message = "Cubicle No cannot contain illegal characters")
    private String cubicleNo;
}
