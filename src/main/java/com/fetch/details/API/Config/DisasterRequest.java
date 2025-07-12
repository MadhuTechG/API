package com.fetch.details.API.Config;


import com.fetch.details.API.Models.ImageLink;
import com.fetch.details.API.Models.Incident;

public class DisasterRequest {
    private Incident incident;
    private ImageLink imageLink;

    public Incident getIncident() {
        return incident;
    }
    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public ImageLink getImageLink() {
        return imageLink;
    }
    public void setImageLink(ImageLink imageLink) {
        this.imageLink = imageLink;
    }
}
