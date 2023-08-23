package com.example.shomsy.services.category;

import com.example.shomsy.dtos.CategoryDTO;
import com.example.shomsy.entities.Category;
import com.example.shomsy.repositories.CategoryRepository;
import com.example.shomsy.util.Helper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repositoryCategory;
    private final Helper helper;
    @Override
    @CacheEvict(value="category",allEntries = true)
    public void saveCategory(List<CategoryDTO> dtos) {
        for (CategoryDTO dto:dtos){

            Category category = new Category();
            category.setName(dto.getName());
            category.setParentId(dto.getParentId());

            repositoryCategory.save(category);
        }
        System.out.println(helper.addSuccess()+repositoryCategory.count()+" category");
    }

    @Override
    @CacheEvict(value="category",allEntries = true)
    public void updateCategory(List<CategoryDTO> dtos) {
        for (CategoryDTO dto : dtos) {
            Optional<Category> optionalCategory = repositoryCategory.findById(dto.getId());
            if (repositoryCategory.findByName(dto.getName())!=null) {
                Category categoryToUpdate = optionalCategory.get();
                categoryToUpdate.setName(dto.getName());
                categoryToUpdate.setParentId(dto.getParentId());

                repositoryCategory.save(categoryToUpdate);
                System.out.println(helper.updateSuccess() + "id: " + dto.getId());
            } else {
                System.out.println("not found category. id:" + dto.getId());
            }
        }
    }

    @Override
    @CacheEvict(value="category",allEntries = true)
    public void deleteCategory(List<CategoryDTO> dtos) {
        for (CategoryDTO dto : dtos) {
            //System.out.println(helper.deleteSuccess()+"Name: "+dto.getName()+"    Age: "+dto.getAge());

            Optional<Category> optionalCategory = repositoryCategory.findById(dto.getId());

            if (optionalCategory.isPresent()) {
                System.out.println("name: "+optionalCategory.get().getName());
                Category categoryToDelete = optionalCategory.get();
                repositoryCategory.delete(categoryToDelete);
            } else {
                System.out.println("not found category. id:" + dto.getId());
            }
        }
    }

    @Override
    @Cacheable("category")
    public Long countCategories() {
        return repositoryCategory.count();
    }
    @Override
    @Cacheable("category")
    public List<Category> getAllCategories() {
        return repositoryCategory.findAll();
    }

    @CacheEvict(value="category",allEntries = true)
    public void deleteAllCategories() {repositoryCategory.deleteAll();}

    @Override
    @Cacheable("category")
    public Category getOneCategory(Long id) {
        //return repository.getReferenceById(id);
        try{
            return repositoryCategory.findById(id).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    @Override
    @Cacheable("category")
    public List<Category> getGenderCategory(Long parentId){

        return repositoryCategory.findByParentId(parentId);
    }
}
