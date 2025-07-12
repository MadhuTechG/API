package com.fetch.details.API.Config;


import com.fetch.details.API.Models.ImageLink;
import com.fetch.details.API.Models.VolunteerDetails;

public class VolunteerImageResponse {
    private VolunteerDetails volunteerDetails;
    private ImageLink imageLink;

    public VolunteerImageResponse(VolunteerDetails volunteerDetails, ImageLink imageLink) {
        this.volunteerDetails = volunteerDetails;
        this.imageLink = imageLink;
    }

    public VolunteerDetails getVolunteerDetails() {
        return volunteerDetails;
    }
    public ImageLink getImageLink() {
        return imageLink;
    }
}

