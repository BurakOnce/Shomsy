package com.example.shomsy.services.store;

import java.util.List;

import com.example.shomsy.dtos.StoreDTO;
import com.example.shomsy.dtos.UserDTO;
import com.example.shomsy.entities.Product;
import com.example.shomsy.entities.Store;
import com.example.shomsy.entities.User;
import com.example.shomsy.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface StoreService {
    void saveStore(List<StoreDTO> dto);
    void updateStore(List<StoreDTO> dto);
     void deleteStore(List<StoreDTO> dto);
    void deleteAllStores();
    Long countStores();
    List<Store> getAllStores();
    Store getOneStore(Long sid);


}
