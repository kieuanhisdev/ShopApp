package com.project.shopapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    String id;

    @NotBlank(message = "Full name is required")
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters")
    @Column(name = "full_name", nullable = false)
    String fullName;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(name = "username", unique = true, nullable = false)
    String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(name = "password", nullable = false)
    String password;

    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    LocalDate dateOfBirth;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    @Column(name = "phone_number")
    String phoneNumber;

    @NotBlank(message = "Gender is required")
    @Column(name = "gender")
    String gender;

    @Email(message = "Invalid email format")
    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "is_verified", nullable = false)
    boolean isVerified = false;

    @Column(name = "status", nullable = false)
    boolean status = true;

    @Column(name = "address")
    String address;

    @Column(name = "profile_picture")
    String profilePicture;

    // Quan hệ Many-to-One: mỗi User chỉ có 1 Role
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    Role role;
}
