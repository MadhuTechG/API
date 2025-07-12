package com.fetch.details.API.Config;


import com.fetch.details.API.Models.ImageLink;
import com.fetch.details.API.Models.Incident;

public class DisasterResponse {
    private final Incident incident;
    private final ImageLink imageLink;

    public DisasterResponse(Incident incident, ImageLink imageLink) {
        this.incident = incident;
        this.imageLink = imageLink;
    }

    public Incident getIncident() {
        return incident;
    }
    public ImageLink getImageLink() {
        return imageLink;
    }
}

