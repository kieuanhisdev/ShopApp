package com.project.shopapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "products") // Table name in the database
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "product_name", length = 100, nullable = false)
    String productName;

    @Column(name = "product_image")
    String productImage;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    Double price;

    @Column(name = "category")
    String category;

    @Column(name = "status")
    Boolean status;

    @Column(name = "import_date")
    LocalDate importDate;
}
