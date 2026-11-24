package tn.sesame.smartTourism.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "email could not be blank")
        @Email(message = "email must be valid")
        String email,

        @NotBlank(message = "password could not be blank")
        String password
) {
}
