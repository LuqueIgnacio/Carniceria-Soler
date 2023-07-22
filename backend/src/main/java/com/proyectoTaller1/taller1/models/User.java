package com.proyectoTaller1.taller1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.time.LocalDate;
import java.util.Collection;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    @Size(max=50)
    @NotBlank
    private String name;

    @Column(name = "last_name", nullable = false, length = 50)
    @Size(max=50)
    @NotBlank
    private String lastName;

    @Column(name = "DNI", nullable = false, length = 9, unique = true)
    @Size(max=9)
    @NotBlank
    private String dni;

    @Column(name = "email", nullable = false, length = 50)
    @Size(max=50)
    @NotBlank
    @Email
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    @Size(max=60)
    @NotBlank
    private String password;

    @Column(name = "phone", nullable = false, length = 15)
    @Size(max=15)
    @NotBlank
    private String phone;

    @Column(name = "address", nullable = false, length = 50)
    @Size(max=50)
    @NotBlank
    private String address;

    @Column(name = "token", nullable = true, length = 15)
    @Size(max=15)
    private String token;

    @Column(name = "confirmed", nullable = false, length = 15)
    private boolean isConfirmed = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate updatedAt;

    @Column(name = "deleted_at", nullable = false)
    @NotNull
    private boolean deletedAt = false;

    @PrePersist
    private void hashPassword(){
        this.password = new BCryptPasswordEncoder(12).encode(this.password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}