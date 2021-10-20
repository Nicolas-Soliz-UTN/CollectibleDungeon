package com.example.collectibledungeon.repositories;

import com.example.collectibledungeon.entities.Collectible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollectibleRepository extends JpaRepository<Collectible, Long> {
    @Query(value = "SELECT * FROM collectible WHERE collectible.active = true", nativeQuery = true)
    List<Collectible> findAllByActive();

    @Query(value = "SELECT * FROM collectible WHERE collectible.active = true && collectible.id = :id", nativeQuery = true)
    Optional<Collectible> findAllByIdAndActive(@Param("id") long id);

    @Query(value = "SELECT * FROM collectible WHERE collectible.name LIKE %:q% AND collectible.active = true", nativeQuery = true)
    List<Collectible> findByName(@Param("q") String q);
}
