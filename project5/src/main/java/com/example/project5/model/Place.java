package com.example.project5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20)")
    private String name;
    @Column(columnDefinition = "varchar(20) ")
    private String area;
    @Column(columnDefinition = "varchar(20) not null")
    private String category;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "place")
    private Set<User> userSet;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "place")
    @PrimaryKeyJoinColumn
    private PlaceDitils placeDitils;

}
