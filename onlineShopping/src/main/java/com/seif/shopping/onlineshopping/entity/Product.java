package com.seif.shopping.onlineshopping.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Image> images;
}
