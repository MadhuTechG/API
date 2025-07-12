package com.fetch.details.API.Config;

import com.fetch.details.API.Models.ImageLink;
import com.fetch.details.API.Models.VolunteerDetails;

public class VolunteerImageRequest {

    private VolunteerDetails volunteerDetails;
    private ImageLink imageLink;

    public VolunteerDetails getVolunteerDetails() {
        return volunteerDetails;
    }
    public void setVolunteerDetails(VolunteerDetails volunteerDetails) {
        this.volunteerDetails = volunteerDetails;
    }

    public ImageLink getImageLink() {
        return imageLink;
    }
    public void setImageLink(ImageLink imageLink) {
        this.imageLink = imageLink;
    }
}

