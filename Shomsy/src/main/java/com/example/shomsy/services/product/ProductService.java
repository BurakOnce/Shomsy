package com.example.shomsy.services.product;

import com.example.shomsy.dtos.ProductDTO;
import com.example.shomsy.dtos.StoreDTO;
import com.example.shomsy.entities.Product;
import com.example.shomsy.entities.Store;

import java.util.List;

public interface ProductService {

    void saveProduct(List<ProductDTO> dto);
    void updateProduct(List<ProductDTO> dto);
    void deleteProduct(List<ProductDTO> dto);
    void deleteAllProducts();
    Long countProducts();
    List<Product> getAllProducts();
    Product getOneProduct(Long pid);

}
