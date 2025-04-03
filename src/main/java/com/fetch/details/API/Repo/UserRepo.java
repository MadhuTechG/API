package com.fetch.details.API.Repo;

import com.fetch.details.API.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long> {
}
