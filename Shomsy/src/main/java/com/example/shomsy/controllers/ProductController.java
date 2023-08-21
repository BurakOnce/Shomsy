package com.example.shomsy.controllers;

import com.example.shomsy.dtos.ProductDTO;
import com.example.shomsy.dtos.StoreDTO;
import com.example.shomsy.entities.Product;
import com.example.shomsy.entities.Store;
import com.example.shomsy.services.product.ProductServiceImpl;
import com.example.shomsy.services.store.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductServiceImpl productService;

    @Autowired
    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @PostMapping("/Product/PostProduct")
    ResponseEntity<String> saveProduct(@RequestBody List<ProductDTO> dtos) {
        productService.saveProduct(dtos);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("saved all products");
    }

    @PostMapping("/Product/UpdateProduct")
    void updateProduct(@RequestBody List<ProductDTO> dtos) {productService.updateProduct(dtos);}

    @DeleteMapping("/Product/DeleteProduct")
    void deleteProduct(@RequestBody List<ProductDTO> dtos) { productService.deleteProduct(dtos);}

    @DeleteMapping("/Product/DeleteAllProducts")
    ResponseEntity<String> deleteAllProducts() { productService.deleteAllProducts();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("deleted all products");}

    @GetMapping("/Product/CountProducts")
    Long countProducts() {return productService.countProducts();}

    @GetMapping("/Product")
    List<Product> getAllProducts() {return productService.getAllProducts();}

    @GetMapping("/Product/GetOneProduct")
    Product getOneProduct(@RequestParam Long pid) {return productService.getOneProduct(pid);}
}
