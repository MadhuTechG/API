package com.fetch.details.API.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidentId;

    @Pattern(
            regexp = "^[A-Za-z ]{3,50}$",
            message = "Type of incident must contain only letters and spaces (3-50 characters)."
    )
    private String typeOfIncident;

    @Size(
            min = 5,
            max = 500,
            message = "Description must be between 5 and 500 characters."
    )
    private String description;

    @Pattern(
            regexp = "^[A-Za-z0-9 ,.-]{3,100}$",
            message = "Location can contain letters, numbers, spaces, commas, periods, and hyphens (3-100 characters)."
    )
    private String location;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    // Constructors
    public Incident() {}

    public Incident(String typeOfIncident, String description, String location, LocalDateTime date, User user, Document document) {
        this.typeOfIncident = typeOfIncident;
        this.description = description;
        this.location = location;
        this.date = date;
        this.user = user;
        this.document = document;
    }

    // Getters and Setters
    public Long getIncidentId() { return incidentId; }
    public void setIncidentId(Long incidentId) { this.incidentId = incidentId; }

    public String getTypeOfIncident() { return typeOfIncident; }
    public void setTypeOfIncident(String typeOfIncident) { this.typeOfIncident = typeOfIncident; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Document getDocument() { return document; }
    public void setDocument(Document document) { this.document = document; }
}
