package com.example.project5.sirves;

import com.example.project5.ApiException.ApiExciption;
import com.example.project5.Responsty.UserResponsty;
import com.example.project5.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServis {
    private final UserResponsty userResponsty;

    public List<User> getAllUser() {
        return userResponsty.findAll();

    }
    public void addUser(User user){
        userResponsty.save(user);

    }
    public void updateUser(User user,Integer id) {
        User user1 = userResponsty.getReferenceById(id);
        if (user1 == null) {
            throw new ApiExciption("customer not found");
        }

       user1.setName(user.getName());
       userResponsty.save(user1);
    }

    public void deleteUser(Integer id){
       User user=userResponsty.getReferenceById(id);
        if(user==null){
            throw new ApiExciption("student not found");
        }

        userResponsty.delete(user);
    }
    public User getUserByHoppy(String hoppy ){
        User user=userResponsty.findUserByHoppy(hoppy);
        if (user==null) {
            throw new ApiExciption("user not found");
        }
        return user;
    }
}
