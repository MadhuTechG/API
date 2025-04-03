package com.fetch.details.API.Controller;

import com.fetch.details.API.Models.User;
import com.fetch.details.API.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

@Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }
@GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
@PostMapping(value = "/save")
    public String saveUser (@RequestBody User user){
        userRepo.save(user);
        return "Saved Successfully..";
    }
@PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody  User user){
        User updateUser = userRepo.findById(id).get();
        updateUser.setName(user.getName());
        updateUser.setType(user.getType());
        updateUser.setLocation(user.getLocation());
        updateUser.setDescription(user.getDescription());
        updateUser.setSeverity(user.getSeverity());
        updateUser.setPincode(user.getPincode());
        userRepo.save(updateUser);
        return "Update Successfully..";
    }
@DeleteMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable Long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Data Deleted Successfully..: " + id;
    }


}
