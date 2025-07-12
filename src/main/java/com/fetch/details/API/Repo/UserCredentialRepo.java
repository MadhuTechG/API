package com.fetch.details.API.Repo;

import com.fetch.details.API.Models.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepo extends JpaRepository<UserCredential, Long> {

    // You can add custom methods here later if needed
}