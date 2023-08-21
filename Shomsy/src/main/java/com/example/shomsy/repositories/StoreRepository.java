package com.example.shomsy.repositories;

import com.example.shomsy.entities.Product;
import com.example.shomsy.entities.User;
import com.example.shomsy.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {


    List<Store> findBySname(String Sname);



}
