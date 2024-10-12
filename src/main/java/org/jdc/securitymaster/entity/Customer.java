package org.jdc.securitymaster.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Code cannot be blank")
    @Size(min = 2, max = 5, message = "Code must be between 2 and 5 ")
    @Pattern(regexp = "[A-Za-z]*", message = "Code cannot contain illegal characters")
    private String code;
    @NotBlank(message = "First name cannot be blanked")
    @Pattern(regexp = "[A-Za-z]*", message = "First name cannot contain illegal characters")
    private String firstName;
    @NotBlank(message = "Last name cannot be blanked")
    @Pattern(regexp = "[A-Za-z]*", message = "Last name cannot contain illegal characters")
    private String lastName;
    @NotBlank(message = "Address cannot be blanked")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address cannot contain illegal characters")
    private String address;
}
