package com.example.project5.ControllerAdvis;

import com.example.project5.ApiException.ApiExciption;
import com.example.project5.Apirespons.Apirespons;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvis {
    @ExceptionHandler(value = ApiExciption.class)
    public ResponseEntity<Apirespons> ApiExsption(ApiExciption e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(new Apirespons(massege));
    }
}
