package com.example.shomsy.services.store;

import com.example.shomsy.dtos.StoreDTO;
import com.example.shomsy.dtos.UserDTO;
import com.example.shomsy.entities.Product;
import com.example.shomsy.entities.Store;
import com.example.shomsy.entities.User;
import com.example.shomsy.repositories.ProductRepository;
import com.example.shomsy.repositories.StoreRepository;
import com.example.shomsy.repositories.UserRepository;
import com.example.shomsy.util.Helper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService{



    private final StoreRepository repositoryStore;
    private final ProductRepository repositoryProduct;
    private final Helper helper;
    @Override
    public void saveStore(List<StoreDTO> dtos) {
        for (StoreDTO dto:dtos){

            Store store = new Store();
            store.setSname(dto.getSname());
            store.setProduct(dto.getProduct());
            store.setUser(dto.getUser());

            repositoryStore.save(store);
        }
        System.out.println(helper.addSuccess()+repositoryStore.count()+" store");
    }

    @Override
    public void updateStore(List<StoreDTO> dtos) {
        for (StoreDTO dto : dtos) {
            Optional<Store> optionalStore = repositoryStore.findById(dto.getSid());
            if (repositoryStore.findBySname(dto.getSname())!=null) {
                Store storeToUpdate = optionalStore.get();
                storeToUpdate.setSname(dto.getSname());
                storeToUpdate.setProduct(dto.getProduct());
                storeToUpdate.setUser(dto.getUser());

                repositoryStore.save(storeToUpdate);
                System.out.println(helper.updateSuccess() + "id: " + dto.getSid());
            } else {
                System.out.println("not found store. id:" + dto.getSid());
            }
        }
    }

    @Override
    public void deleteStore(List<StoreDTO> dtos) {
        for (StoreDTO dto : dtos) {
            //System.out.println(helper.deleteSuccess()+"Name: "+dto.getName()+"    Age: "+dto.getAge());

            Optional<Store> optionalStore = repositoryStore.findById(dto.getSid());

            if (optionalStore.isPresent()) {
                System.out.println("name: "+optionalStore.get().getSname());
                Store storeToDelete = optionalStore.get();
                repositoryStore.delete(storeToDelete);
            } else {
                System.out.println("not found store. id:" + dto.getSid());
            }
        }
    }

    @Override
    public Long countStores() {
        return repositoryStore.count();
    }
    @Override
    public List<Store> getAllStores() {
        return repositoryStore.findAll();
    }

    public void deleteAllStores() {repositoryStore.deleteAll();}

    @Override
    public Store getOneStore(Long sid) {
        //return repository.getReferenceById(id);
        try{
            return repositoryStore.findById(sid).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }


}
