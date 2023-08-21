package com.example.shomsy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"pname"})
        },
        indexes = {
                @Index(name = "store_pname_index", columnList = "pname")
        }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(unique = true, nullable = false)
    private String pname;
    private int price;


    @ManyToOne
    private Category category;
}
