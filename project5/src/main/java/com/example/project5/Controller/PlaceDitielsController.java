package com.example.project5.Controller;

import com.example.project5.DTO.PlaceDiteilsDTO;
import com.example.project5.model.PlaceDitils;
import com.example.project5.sirves.PlaceDitielsServis;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/placeDiesels")
public class PlaceDitielsController {
    private  final PlaceDitielsServis placeDitielsServis;

    @GetMapping("/get")
    public List<PlaceDitils> getAll() {
        return placeDitielsServis.findAll();
    }
    @PostMapping("/addDetails")
    public ResponseEntity addDetailsToPlace(@RequestBody @Valid PlaceDiteilsDTO placeDetailsDTO){
        placeDitielsServis.addPlaceDetails(placeDetailsDTO);
        return ResponseEntity.status(200).body("Done Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatePlaceDetails(@Valid @RequestBody PlaceDitils placeDetails, @PathVariable Integer id){
        placeDitielsServis.updatePlaceDetails(placeDetails,id);
        return ResponseEntity.status(200).body("Updated Done");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlaceDetails(@PathVariable Integer id){
        placeDitielsServis.deletePlaceDetails(id);
        return ResponseEntity.status(200).body("Deleted Done");
    }
    //endPoint

    @GetMapping("/getDetails/{id}")
    public ResponseEntity getPlaceDetails(@PathVariable  Integer id){
        return ResponseEntity.status(200).body(placeDitielsServis.getPlaceDetails(id));
    }

}
