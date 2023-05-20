package com.proyectoTaller1.taller1.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", scale = 2, precision = 7)
    private BigDecimal amount = new BigDecimal(0.0);

    @Column(name = "lastName", nullable = false, length = 50)
    @Size(max = 50)
    @NotBlank
    private String lastName;

    @Column(name = "name", nullable = false, length = 50)
    @Size(max = 50)
    @NotBlank
    private String name;

    @Column(name = "DNI", nullable = false, length = 50)
    @Size(max = 50)
    @NotBlank
    private String DNI;

    @Column(name = "phone", nullable = false, length = 15)
    @Size(max = 15)
    @NotBlank
    private String phone;

    @Column(name = "email", nullable = false, length = 50)
    @Size(max = 50)
    @NotBlank
    @Email
    private String email;

    @Column(name = "address", nullable = false, length = 50)
    @Size(max = 50)
    @NotBlank
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> details;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate createdAt;

}
