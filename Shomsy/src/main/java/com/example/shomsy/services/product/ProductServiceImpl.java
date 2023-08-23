package com.example.shomsy.services.product;

import com.example.shomsy.dtos.ProductDTO;
import com.example.shomsy.dtos.StoreDTO;
import com.example.shomsy.entities.Product;
import com.example.shomsy.entities.Store;
import com.example.shomsy.repositories.ProductRepository;
import com.example.shomsy.repositories.StoreRepository;
import com.example.shomsy.services.store.StoreService;
import com.example.shomsy.util.Helper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repositoryProduct;
    private final Helper helper;
    @Override
    @CacheEvict(value="product",allEntries = true)
    public void saveProduct(List<ProductDTO> dtos) {
        for (ProductDTO dto:dtos){

            Product product = new Product();
            product.setPname(dto.getPname());
            product.setPrice(dto.getPrice());
            product.setCategory(dto.getCategory());

            repositoryProduct.save(product);
        }
        System.out.println(helper.addSuccess()+repositoryProduct.count()+" product");
    }

    @Override
    @CacheEvict(value="product",allEntries = true)
    public void updateProduct(List<ProductDTO> dtos) {
        for (ProductDTO dto : dtos) {
            Optional<Product> optionalProduct = repositoryProduct.findById(dto.getPid());
            if (repositoryProduct.findByPname(dto.getPname())!=null) {
                Product productToUpdate = optionalProduct.get();
                productToUpdate.setPname(dto.getPname());
                productToUpdate.setPrice(dto.getPrice());
                productToUpdate.setCategory(dto.getCategory());

                repositoryProduct.save(productToUpdate);
                System.out.println(helper.updateSuccess() + "id: " + dto.getPid());
            } else {
                System.out.println("not found product. id:" + dto.getPid());
            }
        }
    }

    @Override
    @CacheEvict(value="product",allEntries = true)
    public void deleteProduct(List<ProductDTO> dtos) {
        for (ProductDTO dto : dtos) {
            //System.out.println(helper.deleteSuccess()+"Name: "+dto.getName()+"    Age: "+dto.getAge());

            Optional<Product> optionalProduct = repositoryProduct.findById(dto.getPid());

            if (optionalProduct.isPresent()) {
                System.out.println("name: "+optionalProduct.get().getPname());
                Product productToDelete = optionalProduct.get();
                repositoryProduct.delete(productToDelete);
            } else {
                System.out.println("not found product. id:" + dto.getPid());
            }
        }
    }

    @Override
    @Cacheable("product")
    public Long countProducts() {
        return repositoryProduct.count();
    }
    @Override
    @Cacheable("product")
    public List<Product> getAllProducts() {
        return repositoryProduct.findAll();
    }

    @CacheEvict(value="product",allEntries = true)
    public void deleteAllProducts() {repositoryProduct.deleteAll();}

    @Override
    @Cacheable("product")
    public Product getOneProduct(Long pid) {
        //return repository.getReferenceById(id);
        try{
            return repositoryProduct.findById(pid).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

}
