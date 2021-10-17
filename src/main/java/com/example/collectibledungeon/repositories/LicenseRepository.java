package com.example.collectibledungeon.repositories;

import com.example.collectibledungeon.entities.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
}
