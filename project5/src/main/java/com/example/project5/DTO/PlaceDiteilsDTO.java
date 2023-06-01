package com.example.project5.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaceDiteilsDTO {
    private Integer place_id;
    private String location;
    private String timeWork;
    private String date;
    private String durationOfEvent;
    private Integer capacityOfPlace;

}
