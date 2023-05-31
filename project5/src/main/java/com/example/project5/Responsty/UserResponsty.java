package com.example.project5.Responsty;

import com.example.project5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponsty extends JpaRepository<User,Integer> {

    User findUserByHoppy(String hoppy);
}
