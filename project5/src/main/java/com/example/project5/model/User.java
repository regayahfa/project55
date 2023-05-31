package com.example.project5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(20)")
    private String name;
    @NotEmpty
    @Column(columnDefinition = "varchar(20)")
    private String username;
    @Email
    @NotEmpty
    @Column(columnDefinition = "")
    private String email;
    @Column(columnDefinition = " int ")
    private Integer age;
    @Column(columnDefinition = "varchar (10) not null check(role='admin' or 'user')")
    private String role;
    @NotEmpty
    @Column(columnDefinition = "")
    private String hoppy;
@Size(min = 5 ,max = 15)
    private String password;


@ManyToOne
@JoinColumn(name = "area",referencedColumnName = "id")
@JsonIgnore
    private Place place;

//@OneToMany(mappedBy="place")

    //
}
