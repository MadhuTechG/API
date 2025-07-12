package com.fetch.details.API.Controller;


import com.fetch.details.API.Models.UserCredential;
import com.fetch.details.API.Repo.UserCredentialRepo;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController


@Table(name = "disasterdetails")
@RequestMapping("login")
public class CredController {

    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @PostMapping("/user/saveCredentials")
    public String saveUserCredentials(@RequestBody UserCredential userCredential) {
        userCredentialRepo.save(userCredential);
        return "User credentials saved successfully.";

    }
}