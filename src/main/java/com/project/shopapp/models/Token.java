package com.project.shopapp.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tokens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Token {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;

    @Column(name = "token", length = 225)
    private String token;

    @Column(name = "token_Type", length = 50)
    private String tokenType;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    private boolean revoked;
    private boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
