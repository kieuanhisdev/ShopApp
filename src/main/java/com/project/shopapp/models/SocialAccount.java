package com.project.shopapp.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "social_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SocialAccount {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;

    @Column(name = "provider", nullable = false, length = 20)
    private String provider;

    @Column(name = "provider_id", length = 50)
    private String providerId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "email", length = 50)
    private String email;
}
