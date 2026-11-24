package tn.sesame.smartTourism.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"password","createdAt"})
@Entity
@Table(name="Users",
        uniqueConstraints ={
        @UniqueConstraint(name="unique_email",columnNames = {"email"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "username could not be blank")
    @NotNull
    @Column(nullable = false, unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @JsonIgnore
    //@Size(min = 8, max = 50, message="The password must have at least 8 characters")
    @Pattern(regexp ="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#&@_*])[a-zA-Z\\d#&@_*]{8,}$",
    message = "the password must have at least 1 upper case, 1 lower case, 1 digit and on special character")
    private String password;
    @Email
    @NotNull

    private String email;
    @Pattern(regexp = "[\\d{8}]")
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    boolean active;


}
