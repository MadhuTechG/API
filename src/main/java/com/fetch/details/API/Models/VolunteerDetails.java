package com.fetch.details.API.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "volunteer_info") // Optional: specify a custom table name

public class VolunteerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Java field in lowerCamelCase
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "contact_details")
    private String contactDetails;

    // Java field in lowerCamelCase
    // JSON will use "pastORFutureExperience"
    @Column(name = "past_or_future_experience")
    @JsonProperty("pastORFutureExperience")
    private String pastOrFutureExperience;;

    // --- Getters/Setters ---

    public Long getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getContactDetails() {
        return contactDetails;
    }
    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
    public String getPastORFutureExperience() {
        return pastOrFutureExperience;
    }
    public void setPastORFutureExperience(String pastORFutureExperience) {
        this.pastOrFutureExperience = pastORFutureExperience;
    }

}
