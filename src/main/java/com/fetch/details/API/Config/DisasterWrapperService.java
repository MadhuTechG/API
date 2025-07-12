package com.fetch.details.API.Config;



import com.fetch.details.API.Models.Document;
import com.fetch.details.API.Models.ImageLink;
import com.fetch.details.API.Models.Incident;
import com.fetch.details.API.Models.User;
import com.fetch.details.API.Repo.DocumentRepo;
import com.fetch.details.API.Repo.ImageLinkRepo;
import com.fetch.details.API.Repo.IncidentRepo;
import com.fetch.details.API.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DisasterWrapperService {

    @Autowired
    private IncidentRepo incidentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DocumentRepo documentRepo;

    @Autowired
    private ImageLinkRepo imageLinkRepo;

    public DisasterResponse saveIncidentAndImageLink(DisasterRequest request) {
        Incident incident = request.getIncident();
        ImageLink imageLink = request.getImageLink();

        if (!isValidIncident(incident)) {
            throw new IllegalArgumentException("Incident data is incomplete.");
        }
        if (!isValidImageLink(imageLink)) {
            throw new IllegalArgumentException("ImageLink data is incomplete.");
        }

        User user = incident.getUser();
        if (user != null && isValidUser(user)) {
            user = userRepo.save(user);
            incident.setUser(user);
        }

        Document document = incident.getDocument();
        if (document != null && isValidDocument(document)) {
            document = documentRepo.save(document);
            incident.setDocument(document);
        }

        Incident savedIncident = incidentRepo.save(incident);
        ImageLink savedImageLink = imageLinkRepo.save(imageLink);

        return new DisasterResponse(savedIncident, savedImageLink);
    }

    // Validation helpers
    private boolean isValidIncident(Incident incident) {
        return incident != null &&
                StringUtils.hasText(incident.getTypeOfIncident()) &&
                StringUtils.hasText(incident.getDescription()) &&
                StringUtils.hasText(incident.getLocation()) &&
                incident.getDate() != null;
    }

    private boolean isValidUser(User user) {
        return user != null &&
                StringUtils.hasText(user.getUserName()) &&
                StringUtils.hasText(user.getUserEmail());
    }

    private boolean isValidDocument(Document document) {
        return document != null &&
                StringUtils.hasText(document.getDocumentType());
    }

    private boolean isValidImageLink(ImageLink imageLink) {
        return imageLink != null &&
                StringUtils.hasText(imageLink.getImageUrl());
    }

    public List<Incident> getAllIncidents() {
        return incidentRepo.findAll();
    }

    public List<ImageLink> getAllImageLinks() {
        return imageLinkRepo.findAll();
    }

    public ImageLink getImageLinkById(Long id) {
        return imageLinkRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ImageLink not found with id: " + id));
    }
}

