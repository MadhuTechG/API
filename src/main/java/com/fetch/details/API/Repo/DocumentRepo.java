package com.fetch.details.API.Repo;

import com.fetch.details.API.Models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document, Long> {}
