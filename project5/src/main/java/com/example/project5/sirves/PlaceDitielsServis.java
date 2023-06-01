package com.example.project5.sirves;

import com.example.project5.ApiException.ApiExciption;
import com.example.project5.DTO.PlaceDiteilsDTO;
import com.example.project5.Responsty.PlaceDitielsRepostry;
import com.example.project5.Responsty.PlaceResponsty;
import com.example.project5.model.Place;
import com.example.project5.model.PlaceDitils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceDitielsServis {
    private final PlaceDitielsRepostry placeDitielsRepostry;
    private final PlaceResponsty placeResponsty;

    public List<PlaceDitils> findAll(){
        return placeDitielsRepostry.findAll();
    }
    public void addPlaceDetails(PlaceDiteilsDTO dto){
        Place place =placeResponsty.getReferenceById(dto.getPlace_id());

        if (place==null){
            throw new ApiExciption("Can't add details, place not found");
        }
        PlaceDitils placeDetails=new PlaceDitils(null, dto.getLocation(), dto.getTimeWork(), dto.getTimeWork(), dto.getDurationOfEvent(), dto.getCapacityOfPlace(), place);
    }


    public void updatePlaceDetails(PlaceDitils placeDitils, Integer id){
       PlaceDitils old=placeDitielsRepostry.findPlaceDetailsById(id);
        if(old==null){
            throw new ApiExciption("Not found");
        }

        old.setId(old.getId());
        old.setLocation(old.getLocation());
        old.setTimeWork(old.getTimeWork());
        old.setDate(old.getDate());
        placeDitielsRepostry.save(old);
    }

    public void deletePlaceDetails(Integer id){
       PlaceDitils placeDitils=placeDitielsRepostry.findPlaceDetailsById(id);
        if(placeDitils==null){
            throw new ApiExciption("Not found");
        }
       placeDitielsRepostry.delete(placeDitils);
    }
    //endPoint
    public Place getPlaceDetails(Integer id){
        return placeResponsty.findPlaceById(id);

    }
    public List<PlaceDitils> capacityOfPlace(Integer capacity) {
        List<PlaceDitils> p = placeDitielsRepostry.capacityOfPlace(capacity);
        if (p == null) {
            throw new ApiExciption("Not Found");
        }
        return p;
    }
}
