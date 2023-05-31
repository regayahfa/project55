package com.example.project5.Controller;

import com.example.project5.Apirespons.Apirespons;
import com.example.project5.model.User;
import com.example.project5.sirves.UserServis;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServis userServis;

    @GetMapping("/get")
    public ResponseEntity getAllUser() {
        List<User> userList=userServis.getAllUser();
        return ResponseEntity.status(200).body(userList);
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        userServis.addUser(user);
        return ResponseEntity.status(200).body(new Apirespons("user added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user, @PathVariable Integer id) {
        userServis.updateUser(user,id);
        return ResponseEntity.status(200).body("users Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userServis.deleteUser(id);
        return ResponseEntity.status(200).body("user deleted");

    }

    // take hoppy and return user
    @GetMapping("/get/hoppy")
public  ResponseEntity getUserByHoppy(@Valid @RequestBody User user, @PathVariable String hoppy){
        userServis.getUserByHoppy(hoppy);
        userServis.getAllUser();
        return ResponseEntity.status(200).body("added");
}


}
