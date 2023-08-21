package com.example.shomsy.controllers;

import com.example.shomsy.dtos.StoreDTO;
import com.example.shomsy.dtos.UserDTO;
import com.example.shomsy.entities.Product;
import com.example.shomsy.entities.Store;
import com.example.shomsy.entities.User;
import com.example.shomsy.services.store.StoreServiceImpl;
import com.example.shomsy.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StoreController {
    private StoreServiceImpl storeService;


    @Autowired
    public void setStoreService(StoreServiceImpl storeService) {
        this.storeService = storeService;
    }


    @PostMapping("/Store/PostStore")
    ResponseEntity<String> saveStore(@RequestBody List<StoreDTO> dtos) {
        storeService.saveStore(dtos);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("saved all stores");
    }


    @PostMapping("/Store/UpdateStore")
    void updateStore(@RequestBody List<StoreDTO> dtos) {storeService.updateStore(dtos);}

    @DeleteMapping("/Store/DeleteStore")
    void deleteStore(@RequestBody List<StoreDTO> dtos) { storeService.deleteStore(dtos);}

    @DeleteMapping   ("/Store/DeleteAllStores")
    ResponseEntity<String> deleteAllStores() { storeService.deleteAllStores();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("deleted all stores");}

    @GetMapping("/Store/CountStores")
    Long countStores() {return storeService.countStores();}

    @GetMapping   ("/Store")
    List<Store> getAllStores() {return storeService.getAllStores();}

    @GetMapping   ("/Store/GetOneStore")
    Store getOneStore(@RequestParam Long sid) {return storeService.getOneStore(sid);}


}

