package com.example.auth.repository;

import com.example.auth.entity.GWhitelist;
import org.example.core.repository.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GWhiteListRepository extends JpaRepository<GWhitelist, String> {
    // Custom query methods can be defined here if needed
}
