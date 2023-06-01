package com.example.project5.Responsty;

import com.example.project5.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceResponsty extends JpaRepository<Place, Integer> {
    Place findAllById(Integer id);
    Place findPlaceById(Integer id);
}
