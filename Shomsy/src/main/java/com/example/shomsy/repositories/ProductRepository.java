package com.example.shomsy.repositories;

import com.example.shomsy.entities.Product;
import com.example.shomsy.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByPname(String Pname);

}
