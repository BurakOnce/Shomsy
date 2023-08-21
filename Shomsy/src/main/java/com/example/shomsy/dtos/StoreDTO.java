package com.example.shomsy.dtos;

import com.example.shomsy.entities.Product;
import com.example.shomsy.entities.User;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreDTO {

    private Long sid;
    private String sname;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Product> product;
}
