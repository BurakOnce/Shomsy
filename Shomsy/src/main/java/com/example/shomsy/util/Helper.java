package com.example.shomsy.util;

import org.springframework.stereotype.Component;

@Component
public class Helper {
    public String addSuccess(){
        return "added successful  ";}
    public String deleteSuccess(){
        return "deleted: ";
    }

    public String updateSuccess() {return "uptaded successful : ";}
}
