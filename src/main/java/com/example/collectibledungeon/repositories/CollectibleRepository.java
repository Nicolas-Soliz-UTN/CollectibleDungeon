package com.example.collectibledungeon.repositories;

import com.example.collectibledungeon.entities.Collectible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectibleRepository extends JpaRepository<Collectible, Long> {
    @Query(value = "SELECT * FROM collectibles WHERE collectibles.active = true", nativeQuery = true)
    List<Collectible> findAllByActive();

    @Query(value = "SELECT * FROM collectibles WHERE collectibles.active = true && collectibles.id = :id", nativeQuery = true)
    List<Collectible> findAllByIdAndActive(@Param("id") long id);
}
