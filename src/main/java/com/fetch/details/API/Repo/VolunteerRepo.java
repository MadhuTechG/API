package com.fetch.details.API.Repo;

import com.fetch.details.API.Models.VolunteerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepo extends JpaRepository<VolunteerDetails, Long> {
}
