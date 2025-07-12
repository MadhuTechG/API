package com.fetch.details.API.Config;



import com.fetch.details.API.Models.ImageLink;
import com.fetch.details.API.Models.VolunteerDetails;
import com.fetch.details.API.Repo.ImageLinkRepo;
import com.fetch.details.API.Repo.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class VolunteerImageService {

    @Autowired
    private VolunteerRepo volunteerDetailsRepo;

    @Autowired
    private ImageLinkRepo imageLinkRepo;

    public VolunteerImageResponse saveVolunteerAndImage(VolunteerImageRequest request) {
        VolunteerDetails volunteer = request.getVolunteerDetails();
        ImageLink imageLink = request.getImageLink();

        if (!isValidVolunteer(volunteer)) {
            throw new IllegalArgumentException("Volunteer details contain null or empty fields.");
        }
        if (!isValidImageLink(imageLink)) {
            throw new IllegalArgumentException("Image link URL is null or empty.");
        }

        VolunteerDetails savedVolunteer = volunteerDetailsRepo.save(volunteer);
        ImageLink savedImageLink = imageLinkRepo.save(imageLink);

        return new VolunteerImageResponse(savedVolunteer, savedImageLink);
    }

    private boolean isValidVolunteer(VolunteerDetails volunteer) {
        return volunteer != null &&
                StringUtils.hasText(volunteer.getFullName()) &&
                StringUtils.hasText(volunteer.getEmailId()) &&
                StringUtils.hasText(volunteer.getContactDetails()) &&
                StringUtils.hasText(volunteer.getPastORFutureExperience());
    }

    private boolean isValidImageLink(ImageLink imageLink) {
        return imageLink != null &&
                StringUtils.hasText(imageLink.getImageUrl());
    }
}
