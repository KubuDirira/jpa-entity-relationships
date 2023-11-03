package com.kubudirira.ecrudv1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @ManyToMany(
            mappedBy = "products",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Category> categories;

}
