package com.example.collectibledungeon.repositories;

import com.example.collectibledungeon.entities.Collectable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectableRepository extends JpaRepository<Collectable, Long> {
    @Query(value = "SELECT * FROM collectables WHERE collectables.active = true", nativeQuery = true)
    List<Collectable> findAllByActive();

    @Query(value = "SELECT * FROM collectables WHERE collectables.active = true && collectables.id = :id", nativeQuery = true)
    List<Collectable> findAllByIdAndActive(@Param("id") long id);
}
