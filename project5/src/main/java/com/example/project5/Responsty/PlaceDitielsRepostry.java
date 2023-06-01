package com.example.project5.Responsty;

import com.example.project5.model.Place;
import com.example.project5.model.PlaceDitils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceDitielsRepostry extends JpaRepository<PlaceDitils, Integer> {
    PlaceDitils findPlaceDetailsById(Integer id);
    Place findAllById(Integer id);

    @Query("select place from PlaceDitils place where place.capacityOfPlace<5")
    List<PlaceDitils> capacityOfPlace(Integer capacity);
}
