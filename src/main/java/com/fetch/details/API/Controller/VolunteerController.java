package com.fetch.details.API.Controller;

import com.fetch.details.API.Models.VolunteerDetails;
import com.fetch.details.API.Repo.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    private final VolunteerRepo volunteerRepo;

    @Autowired
    public VolunteerController(VolunteerRepo volunteerRepo) {
        this.volunteerRepo = volunteerRepo;
    }

    @GetMapping("/list")
    public List<VolunteerDetails> getAllVolunteers() {
        return volunteerRepo.findAll();
    }

    @PostMapping("/info")
    public String saveVolunteer(@RequestBody VolunteerDetails volunteer) {
        volunteerRepo.save(volunteer);
        return "Volunteer saved successfully!";
    }
}