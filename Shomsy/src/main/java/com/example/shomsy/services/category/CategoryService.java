package com.example.shomsy.services.category;

import com.example.shomsy.dtos.CategoryDTO;
import com.example.shomsy.dtos.ProductDTO;
import com.example.shomsy.entities.Category;
import com.example.shomsy.entities.Product;

import java.util.List;

public interface CategoryService {

    void saveCategory(List<CategoryDTO> dto);
    void updateCategory(List<CategoryDTO> dto);
    void deleteCategory(List<CategoryDTO> dto);
    void deleteAllCategories();
    Long countCategories();
    List<Category> getAllCategories();
    Category getOneCategory(Long id);

    List<Category> getGenderCategory(Long parentId);
}
