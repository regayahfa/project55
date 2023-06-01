package com.example.project5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDitils {
    @Id
    private  Integer id;
    @Column(columnDefinition = "varchar(100) not null")
    private  String location;
    @Column(columnDefinition = "varchar(8) not null")
    private String timeWork;
    @Column(columnDefinition = "varchar(20) not null")
    private String date;
    @Column(columnDefinition = "varchar(20) not null")
    private String durationOfEvent;
    @Column(columnDefinition = "int not null")
    private Integer capacityOfPlace;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Place place;
}
