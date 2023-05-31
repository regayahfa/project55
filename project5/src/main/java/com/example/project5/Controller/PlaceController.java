package com.example.project5.Controller;

import com.example.project5.Apirespons.Apirespons;
import com.example.project5.model.Place;
import com.example.project5.model.User;
import com.example.project5.sirves.PlaceSirvis;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/place")
public class PlaceController {
private final PlaceSirvis placeSirvis;
    @GetMapping("/get")
    public ResponseEntity getAllPlace() {
        List<Place> placeList=placeSirvis.getAllPlace();
        return ResponseEntity.status(200).body(placeList);
    }
    @PostMapping("/add")
    public ResponseEntity addPlace(@Valid @RequestBody Place place) {
        placeSirvis.addPlace(place);
        return ResponseEntity.status(200).body(new Apirespons("place added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatePlace(@Valid @RequestBody Place place, @PathVariable Integer id) {
        placeSirvis.updatePlace(place,id);
        return ResponseEntity.status(200).body("place Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlace(@PathVariable Integer id) {
       placeSirvis.deletePlace(id);
        return ResponseEntity.status(200).body("place deleted");

    }
}
