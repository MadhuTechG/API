package com.fetch.details.API.Repo;

import com.fetch.details.API.Models.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepo extends JpaRepository<Incident, Long> {}
