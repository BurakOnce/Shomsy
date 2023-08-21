package com.example.shomsy.controllers;

import com.example.shomsy.dtos.CategoryDTO;
import com.example.shomsy.dtos.ProductDTO;
import com.example.shomsy.entities.Category;
import com.example.shomsy.entities.Product;
import com.example.shomsy.services.category.CategoryServiceImpl;
import com.example.shomsy.services.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryServiceImpl categoryService;

    @Autowired
    public void setCategoryService(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping("/Category/PostCategory")
    ResponseEntity<String> saveCategory(@RequestBody List<CategoryDTO> dtos) {
        categoryService.saveCategory(dtos);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("saved all categories");
    }

    @PostMapping("/Category/UpdateCategory")
    void updateCategory(@RequestBody List<CategoryDTO> dtos) {categoryService.updateCategory(dtos);}

    @DeleteMapping("/Category/DeleteCategory")
    void deleteCategory(@RequestBody List<CategoryDTO> dtos) { categoryService.deleteCategory(dtos);}

    @DeleteMapping("/Category/DeleteAllCategories")
    ResponseEntity<String> deleteAllProducts() { categoryService.deleteAllCategories();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("deleted all categories");}

    @GetMapping("/Category/CountCategories")
    Long countCategories() {return categoryService.countCategories();}

    @GetMapping("/Category")
    List<Category> getAllCategories() {return categoryService.getAllCategories();}

    @GetMapping("/Category/GetOneCategory")
    Category getOneCategory(@RequestParam Long id) {return categoryService.getOneCategory(id);}

    @GetMapping("/Category/GetGenderCategory")
    List<Category> getGenderCategory(@RequestParam Long parentId) {return categoryService.getGenderCategory(parentId);}
}
