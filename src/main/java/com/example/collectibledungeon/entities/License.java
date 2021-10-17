package com.example.collectibledungeon.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name, founder, owner, country;
    private int year;
    private boolean active;

    @OneToMany(mappedBy = "license")
    private List<Collectible> collectibles;
}
