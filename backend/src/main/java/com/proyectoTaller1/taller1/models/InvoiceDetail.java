package com.proyectoTaller1.taller1.models;

import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoice_details")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", scale = 2, precision = 7, nullable = false)
    private BigDecimal price;

    @Column(name = "cost_price", scale = 2, precision = 7, nullable = false)
    private BigDecimal costPrice;

    @Column(name = "quantity", nullable = false)
    private Byte quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
