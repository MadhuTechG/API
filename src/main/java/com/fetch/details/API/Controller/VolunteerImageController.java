package com.fetch.details.API.Controller;



import com.fetch.details.API.Config.VolunteerImageRequest;
import com.fetch.details.API.Config.VolunteerImageResponse;
import com.fetch.details.API.Config.VolunteerImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VolunteerImageController {

    @Autowired
    private VolunteerImageService volunteerImageService;

    @PostMapping("/volunteer-image")
    public VolunteerImageResponse saveVolunteerAndImage(@RequestBody VolunteerImageRequest request) {
        return volunteerImageService.saveVolunteerAndImage(request);
    }
}
