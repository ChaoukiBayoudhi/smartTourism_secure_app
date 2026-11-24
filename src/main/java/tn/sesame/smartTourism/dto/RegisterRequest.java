package tn.sesame.smartTourism.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "email could not be blank")
        @Email(message = "email must be valid")
        String email,

        @NotBlank(message = "password could not be blank")
        @Size(min = 8, message = "the password must have at least 8 characters")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#&@_*])[a-zA-Z\\d#&@_*]{8,}$",
                message = "the password must have at least 1 upper case, 1 lower case, 1 digit and one special character (#&@_*)"
        )
        String password,

        @NotBlank(message = "firstName could not be blank")
        String firstName,

        @NotBlank(message = "lastName could not be blank")
        String lastName,

        @Pattern(regexp = "\\d{8}", message = "phone must contain exactly 8 digits")
        String phone
) {
}
