package com.example.shomsy.repositories;

import com.example.shomsy.entities.Category;
import com.example.shomsy.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category,Long>{

    List<Category> findByName(String name);

    List<Category> findByParentId(Long parentId);

}
