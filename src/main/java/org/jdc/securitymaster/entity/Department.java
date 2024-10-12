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
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Code cannot be blank")
    @Size(min = 2, max = 5, message = "Code must be between 2 and 5")
    @Pattern(regexp = "[A-Za-z]*", message = "Code cannot contain illegal character")
    private String code;
    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "[A-Za-z ]*", message = "Name cannot contain illegal character")
    private String name;
    @NotBlank(message = "Country cannot be blank")
    @Pattern(regexp = "[A-Za-z ]*", message = "Country cannot contain illegal character")
    private String country;
}
