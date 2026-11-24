package tn.sesame.smartTourism.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"password", "createdAt"})
@Entity
@Table(name = "Users",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_email", columnNames = {"email"})
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "username could not be blank")
    @Column(nullable = false, unique = true)
    private String username;

    private String firstName;
    private String lastName;

    @JsonIgnore
    // Password strength is validated on RegisterRequest (plaintext).
    // Do not put @Pattern here: after hashing, the stored value will no longer match.
    private String password;

    @Email(message = "email must be valid")
    @NotBlank(message = "email could not be blank")
    @Column(nullable = false)
    private String email;

    @Pattern(regexp = "\\d{8}", message = "phone must contain exactly 8 digits")
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    boolean active;
}
