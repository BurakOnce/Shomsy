package com.example.shomsy.dtos.response;


import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public void setErrorDetailsProperties(LocalDateTime timeStamp, String message, String details){
        this.setTimeStamp(timeStamp);
        this.setMessage(message);
        this.setDetails(details);
    }
}