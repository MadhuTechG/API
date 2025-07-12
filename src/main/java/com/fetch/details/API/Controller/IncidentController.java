package com.fetch.details.API.Controller;

import com.fetch.details.API.Models.Document;
import com.fetch.details.API.Models.Incident;
import com.fetch.details.API.Models.User;
import com.fetch.details.API.Repo.DocumentRepo;
import com.fetch.details.API.Repo.IncidentRepo;
import com.fetch.details.API.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    @Autowired
    private IncidentRepo incidentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DocumentRepo documentRepo;

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentRepo.findAll();
    }

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        // Save the embedded user
        User user = incident.getUser();
        if (user != null) {
            user = userRepo.save(user);
            incident.setUser(user);
        }

        // Save the embedded document
        Document document = incident.getDocument();
        if (document != null) {
            document = documentRepo.save(document);
            incident.setDocument(document);
        }

        return incidentRepo.save(incident);
    }
}