package com.example.shomsy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"sname"})
        },
        indexes = {
                @Index(name = "store_sname_index", columnList = "sname")
        }
)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Column(unique = true, nullable = false)
    private String sname;

    @ManyToOne
    private User user;
    @OneToMany
    private List<Product> product;
}
