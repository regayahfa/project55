package com.example.project5.sirves;

import com.example.project5.ApiException.ApiExciption;
import com.example.project5.Responsty.PlaceResponsty;
import com.example.project5.model.Place;
import com.example.project5.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceSirvis {
    private final PlaceResponsty placeResponsty;

    public List<Place> getAllPlace() {
        return placeResponsty.findAll();

    }

    public void addPlace(Place place){
        placeResponsty.save(place);

    }
    public void updatePlace(Place place,Integer id) {
       Place place1 = placeResponsty.getReferenceById(id);
        if (place1 == null) {
            throw new ApiExciption("customer not found");
        }

        place1.setName(place.getName());
        placeResponsty.save(place1);
    }
    public void deletePlace(Integer id){
       Place place=placeResponsty.getReferenceById(id);
        if(place==null){
            throw new ApiExciption("student not found");
        }

        placeResponsty.delete(place);
    }



}
